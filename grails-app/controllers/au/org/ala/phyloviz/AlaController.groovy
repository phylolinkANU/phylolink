package au.org.ala.phyloviz
import au.org.ala.soils2sat.LayerDefinition
import au.org.ala.soils2sat.LayerTreeNode
import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.JSONObject
import org.springframework.web.multipart.MultipartHttpServletRequest
import org.springframework.web.multipart.commons.CommonsMultipartFile

class AlaController {
    def webService
    def utilsService
    def layerService
    def alaService
    def characterService

    static allowedMethods = [saveAsList: 'POST', uploadData: 'POST']

    def index() {

    }

    def getOccurrenceRecords(speciesName, layer, region){
        layer = layer ?: ''
        region = region ?: ''
        def occurrenceUrl = this.grailsApplication.config.occurrences.replace('SEARCH', speciesName.encodeAsURL()).replace('LAYER',layer.encodeAsURL()).replace('REGION',region.encodeAsURL())
        def occurrencesResult = JSON.parse( webService.get( occurrenceUrl ) );
        return occurrencesResult;
    }

    def extractFacets( occurrencesResult,speciesName ){
        def v, var, summary = []
        def config = grailsApplication.config.intersectionMeta
        occurrencesResult = occurrencesResult?.facetResults[0]
        if ( occurrencesResult?.fieldResult ) {
            for( def i = 0 ; i < occurrencesResult.fieldResult?.size(); i++ ){
                var = [:]
                v = occurrencesResult.fieldResult[ i ];
                v.label = v.label?: 'n/a';
                var[config.name] = speciesName
                var[config.var] = v.label
                var[config.count] = v.count
                summary.push( var )
            }
        }
        return summary
    }

    def getIntersections( species, layer, region ){
        def summary = []
        def occurrencesResult
        for( speciesName in species ){
            occurrencesResult = this.getOccurrenceRecords( speciesName, layer, region)
            summary.addAll( this.extractFacets( occurrencesResult, speciesName ))
        }
        return  summary;
    }

    /**
     * get intersection with layer and a specified query id.
     * @param species
     * @param layer
     * @param region
     * @return
     */
    def getQidIntersections( qid, layer, region ){
        def summary = []
        def occurrencesResult
        occurrencesResult = this.getOccurrenceRecords( qid, layer, region)
        summary.addAll( this.extractFacets( occurrencesResult, qid ))
        return  summary;
    }

    def getOccurrenceIntersections(){
        def species = JSON.parse( params.species )
        def download = params.download?:"false"
        def layer = params.layer
        def region = params.region
        download = download.toBoolean();
        def data = this.getIntersections( species, layer, region )

        if( download ){
            response.setHeader('Content-disposition','attachment; filename=data.csv')
            render ( contentType: 'text/plain', text: utilsService.convertJSONtoCSV(data) )
        } else {
            render ( contentType: 'text/plain', text: data as JSON )
        }

    }

    def getEnvLayers(){
        def data = this.getLayers( grailsApplication.config.layersMeta.env )
        render(contentType: 'application/json', text: data as JSON )
    }

    def getClLayers(){
        def data = this.getLayers( grailsApplication.config.layersMeta.cl )
        render(contentType: 'application/json', text: data as JSON )
    }

    def getLayers( type ){
        def result =[]
        def url = grailsApplication.config.layers
        def data = JSON.parse( webService.get( url ) )
        def code='';

        switch ( type ){
            case grailsApplication.config.layersMeta.cl:
                code = 'cl';
                break;
            case grailsApplication.config.layersMeta.env:
                code = 'el';
                break;
        }
        data.eachWithIndex { def entry, int i ->
            if( type == entry.type ){
                entry.id = code + entry.id
                entry.label = entry.displayname
                result.push( entry )
            }
        }
        return result;
    }

    /**
     * get all the layers in atlas of living australia
     */
    def getAllLayers(){
        def result = alaService.getAllLayers();
        if(params.callback){
            render(contentType: 'text/javascript', text: "${params.callback}(${result as JSON})")
        } else {
            render(contentType: 'application/json', text: result as JSON)
        }
    }

    def browseLayersFragment() {
        log.debug( params.type )
        log.debug( grailsApplication.config.layersMeta.env )
        def layerData = getLayers( params.type );
        def results = new ArrayList<LayerDefinition>()
        layerData.each {
            def layer = new LayerDefinition()
            it.each {
                if (it.value && layer.hasProperty(it.key)) {
                    layer[it.key] = it.value
                }
            }
            results.add(layer)
        }
        def root = new LayerTreeNode(label: 'Unclassified')
        results.each {
            if (it.classification1) {
                def topLevelFolder =  root.getOrAddFolder(it.classification1)

                if (it.classification2) {
                    def secondLevel = topLevelFolder.getOrAddFolder(it.classification2)
                    secondLevel.addLayer(it)
                } else {
                    topLevelFolder.addLayer(it)
                }
            } else {
                root.addLayer(it)
            }
        }
        [layerTree: root]
    }

    def layerSelectionDialog(){

    }

    def layerSummaryFragment(){
        def layerName = params.layerName;
        def info = [:]
        LayerDefinition layerDefinition = null
        if (layerName) {
            info = layerService.getLayerInfo(layerName)
            layerDefinition = new LayerDefinition()
            info.each {
                if (it.value && layerDefinition.hasProperty(it.key)) {
                    layerDefinition[it.key] = it.value
                }
            }
        }
        [layerName: layerName, layerDefinition: layerDefinition]
    }

    def getAlaLsid(){
        def study = params.study
        def tree = params.tree
        utilsService.lookupLeafName( study, tree);
        render( contentType: 'application/json', text: utilsService.lookupLeafName( study, tree) as JSON )
    }

    /**
     * creates charjson which can be consumed by phylojive.
     * params
     * data resource id
     * field name that will have key of charjson
     * and a list of field names that will be an attribute in charjson
     */
    def getSandboxCharJson(){
        def drid = params.drid;
        def key = params.key
        def fields = JSON.parse(params.fields);
        def result = alaService.getSandboxCharJson(drid, key, fields);
        if(params.callback){
            render(contentType: 'text/javascript', text: "${params.callback}(${result as JSON})")
        } else {
            render(contentType: 'application/json', text: result as JSON)
        }
    }

    def jsonp(){
        // do not use decodeUrl function since it converts + to whitespace.
        def url = params.url
        def result = webService.get(url);
        log.debug(result);
        log.debug(url);
        result = JSON.parse(result)
        if(params.callback){
            render(contentType: 'text/javascript', text: "${params.callback}(${result as JSON})")
        } else {
            render(contentType: 'application/json', text: result as JSON)
        }
    }

    def dynamicFacets(){
        def drid = params.drid
        def result = alaService.getDynamicFacets(drid);
        if(params.callback){
            render(contentType: 'text/javascript', text: "${params.callback}(${result as JSON})")
        } else {
            render(contentType: 'application/json', text: result as JSON)
        }
    }

    def facets(){
        def drid = params.drid
//        def json = webService.get('http://sandbox.ala.org.au/biocache-service/occurrences/search?q=data_resource_uid:drt2783');
//        json = JSON.parse(json);
        def source = params.source;
        def result ;
        switch (source){
            case 'sandbox':
                result = alaService.getSandboxFacets(params.q, params.fq);
                break;
            case 'ala':
                result = alaService.getAlaFacets(params.q, params.fq);
                break;
        }
        if(params.callback){
            render(contentType: 'text/javascript', text: "${params.callback}(${result as JSON})")
        } else {
            render(contentType: 'application/json', text: result as JSON)
        }
    }

    /**
     * save params using
     */
    def saveQuery(){
        String list = params.speciesList?:'[]';
        log.debug(list);
        def json = JSON.parse(list);
        def result;
        if(json){
            result = alaService.saveQuery(json);
            result = [qid: result];
            if(params.callback){
                render(contentType: 'text/javascript', text: "${params.callback}(${result as JSON})")
            } else {
                render(contentType: 'application/json', text: result as JSON)
            }
        }
    }

    /**
     * converts character data stored in list tool into charJSON
     */
    def getCharJson(){
        String drid = params.drid;
        String cookie = request.getHeader('Cookie')
        log.debug(drid)
        def result = [:];
        if(drid){
            result = alaService.getListCharJson(drid, cookie);
        }

        if(params.callback){
            render(contentType: 'text/javascript', text: "${params.callback}(${result as JSON})")
        } else {
            render(contentType: 'application/json', text: result as JSON)
        }
    }

    /**
     * create a list on list tool.
     * params:
     * file: csv file
     * title: name of list
     * column: column with scientific name
     */
    def saveAsList(){
        def result = [:], id;
        def file = isMultipartRequest() ? request.getFile('file') : null;
        def reader, colIndex, colName, title;
        String cookie = request.getHeader('Cookie');
        log.debug('cooike: '+cookie);
        log.debug(isMultipartRequest());
        log.debug('cookies:'+request.getCookies());
        JSONObject formParams = JSON.parse(request.getParameter("formParms"));
        title = formParams['title']
        colIndex = formParams['column']['id']
//        colIndex = Integer.parseInt(colIndex);
        colName  = formParams['column']['displayname']
        reader = utilsService.getCSVReaderForCSVFileUpload(file, utilsService.detectSeparator(file) as char)
        result = alaService.createList(reader, title, colIndex, cookie);
        if(result?.druid){
            def url = getUrl(result.druid);
            id = result.id
            result = [:]
            result['url'] = url
            result['title'] = title
            result['id'] = id;
        } else {
            result['error'] = 'error executing function';
        }

        if(params.callback){
            render(contentType: 'text/javascript', text: "${params.callback}(${result as JSON})")
        } else {
            render(contentType: 'application/json', text: result as JSON)
        }
    }

    private boolean isMultipartRequest() {
        request instanceof MultipartHttpServletRequest
    }

    /**
     *
     * @param druid
     * @return
     */
    def getUrl(druid){
        return createLink(controller: 'ala', action: 'getCharJson') + '?drid=' + druid;
    }

    /**
     * keep session alive
     */
    def keepSessionAlive(){
        render(contentType: 'application/json', text: ['status':'OK'] as JSON)
    }

    /**
     * this function just renders a page explaining pd
     */
    def pd(){

    }

    /**
     * upload data
     */
    def uploadData(){
        def result;
        String type = params.type?:'occurrence';
        String title = params.title;
        String scientificName = params.scientificName;
        String cookie = request.getHeader('Cookie')
        // TODO: get file and store it.
        CommonsMultipartFile file = request.getFile('myFile');
        FileInputStream is = file.getInputStream();
        def path = is.path;
        File tempFile = new File(path);

        result = alaService.uploadData(type, title, scientificName, tempFile, cookie);
        render(contentType: 'application/json', text: result as JSON);
    }
}