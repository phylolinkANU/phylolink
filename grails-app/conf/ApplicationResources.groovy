def alaBaseUrl = "https://www.ala.org.au"

modules = {

//    jquery{
//        resource url:[dir: 'js', file: 'jquery.1.11.2.min.js']
//    }
//    core {
//        dependsOn 'jquery'
//        resource url: "${grailsApplication.config.ala.baseURL ?: 'http://www.ala.org.au'}/wp-content/themes/ala2011/images/favicon.ico", attrs: [type: 'ico'], disposition: 'head'
//        resource url: [dir: 'js', file: 'html5.js', plugin: "ala-web-theme"], wrapper: { s -> "<!--[if lt IE 9]>$s<![endif]-->" }, disposition: 'head'
//    }

    bootstrapApp {
        dependsOn 'core', 'font-awesome'
        resource url:alaBaseUrl + '/commonui-bs2/css/bootstrap.min.css', attrs:[media:'all']
        resource url:alaBaseUrl + '/commonui-bs2/css/bootstrap-responsive.min.css', attrs:[media:'all']
        resource url:alaBaseUrl + '/commonui-bs2/css/ala-styles.css', attrs:[media:'all']
        resource url:alaBaseUrl + '/commonui-bs2/js/bootstrap.js'
    }

    core {
        dependsOn 'jquery'
        resource url:[plugin: 'ala-bootstrap2', dir: 'js',file:'html5.js'], wrapper: { s -> "<!--[if lt IE 9]>$s<![endif]-->" }
        resource url:alaBaseUrl + '/commonui-bs2/js/application.js'
    }

    knockout {
        resource url: 'js/knockout-2.3.0.js',disposition: 'head'
    }

    knockout3 {
        resource url: 'js/knockout-3.0.0.js'
        resource url: 'js/knockout-custom-bindings.js'
    }

    create{
        resource url: [dir:'js', file: 'jquery.validate.min.js']
        resource url: [dir:'js', file: 'additional-methods.min.js']
    }

    application {
        resource url: [dir: 'css', file: "maingsp.css"]
        resource url: [dir: 'css', file: "jquery-ui.css"]
        resource url: [dir: "js", file: "jquery-ui.min.js"]
        resource url: [dir:'js', file: 'jquery.cookie.js']
    }

    bugherd {
        resource url:[dir: 'js', file: 'bugherd.js']
    }

    appSpecific {
        resource url: [dir: "js", file: 'application.js'], disposition: 'head'
        resource url: [dir: "js", file: 'utils.js']
    }

    form {
        resource url: [dir: "js", file: 'knockout-2.3.0.js'],disposition: 'head'
    }

//    chart{
//        resource url: 'https://www.google.com/jsapi', disposition: 'head'
//    }

    emitter{
        resource url: 'js/emitter.js'
    }

    jqxCore {
        dependsOn( 'jquery' )
        resource url: [dir: "/jqwidgets/styles", file: "jqx.base.css"],disposition: 'head'
        resource url: [dir: '/jqwidgets', file: 'jqxcore.js'], disposition: 'head'
    }

    jqxGrid {
        dependsOn('jqxCore')
        resource url: [dir: '/jqwidgets', file: 'jqxdata.js' ], disposition: 'head'
        resource url: [dir: '/jqwidgets', file: 'jqxbuttons.js'], disposition: 'head'
        resource url: [dir: '/jqwidgets', file: 'jqxscrollbar.js'], disposition: 'head'
        resource url: [dir: '/jqwidgets', file: 'jqxmenu.js'], disposition: 'head'
        resource url: [dir: '/jqwidgets', file: 'jqxlistbox.js'], disposition: 'head'
        resource url: [dir: '/jqwidgets', file: 'jqxdropdownlist.js'], disposition: 'head'
        resource url: [dir: '/jqwidgets', file: 'jqxgrid.js'], disposition: 'head'
        resource url: [dir: '/jqwidgets', file: 'jqxgrid.selection.js'], disposition: 'head'
        resource url: [dir: '/jqwidgets', file: 'jqxgrid.columnsresize.js'], disposition: 'head'
        resource url: [dir: '/jqwidgets', file: 'jqxgrid.filter.js'], disposition: 'head'
        resource url: [dir: '/jqwidgets', file: 'jqxgrid.sort.js'], disposition: 'head'
        resource url: [dir: '/jqwidgets', file: 'jqxgrid.pager.js'], disposition: 'head'
        resource url: [dir: '/jqwidgets', file: 'jqxgrid.grouping.js'], disposition: 'head'
        resource url: [dir: '/jqwidgets', file: 'jqxgrid.edit.js'], disposition: 'head'
    }

    slickgrid {
        dependsOn( 'jquery', "jquery-ui" )
        resource url: 'slickgrid/jquery.event.drag-2.2.js', disposition: 'head'
        resource url: 'slickgrid/slick.core.js', disposition: 'head'
        resource url: 'slickgrid/slick.grid.js', disposition: 'head'
        resource url: 'slickgrid/slick.dataview.js', disposition: 'head'
        resource url: 'slickgrid/slick.formatters.js', disposition: 'head'
        resource url: 'slickgrid/slick.editors.js', disposition: 'head'
        resource url: 'slickgrid/slickgrid.bvp.js', disposition: 'head'
        resource url: 'slickgrid/slick.grid.css', disposition: 'head'
    }

    leaflet{
        dependsOn('jquery')
        resource url: 'css/leaflet.v0.7.3.css', disposition: 'head'
        resource url: 'css/slider.css'
        resource url: 'css/leaflet.fullscreen.v0.0.2.css'
        resource url: 'css/Control.Legend.css'
        resource url: 'css/Control.Loading.css'
        resource url: 'js/spin.min.v2.0.1.js'
        resource url: 'js/leaflet.v0.7.3.js', disposition: 'head'
        resource url: 'js/Leaflet.fullscreen.v0.0.2.min.js', disposition: 'head'
        resource url: 'js/Control.Checkbox.js'
        resource url: 'js/Control.Legend.js'
        resource url: 'js/Control.Loading.js'
        resource url: 'js/Control.Select.js'
        resource url: 'js/Control.Slider.js'
        resource url: 'js/bootstrap-slider.js'
    }

    phylojive {
        dependsOn('bootstrap','emitter','knockout3')
        resource url: 'js/spin.min.v2.0.1.js'
        resource url: 'css/PhyloJive.css', disposition: 'head'
        resource url: 'js/jsphylosvg-min.js', disposition: 'head'
        resource url: 'js/jit.js', disposition: 'head'
        resource url: 'js/PJ.js'
        resource url: 'js/Filter.js'
        resource url: 'js/Habitat.js'
    }

    character {
        dependsOn('knockout3','emitter')
        resource url: 'js/knockout-sortable.min.js'
        resource url: 'js/Character.js'
        resource url: 'css/PhyloJive.css'
    }

    records {
        dependsOn('knockout3','emitter')
        resource url: 'js/Records.js'
    }

    map{
        dependsOn('emitter','leaflet')
        resource url: 'js/Map.js'
    }

    nano{
        dependsOn('jquery')
        resource url: 'css/nanoscroller.css'
        resource url:'js/overthrow.min.js'
        resource url: 'js/jquery.nanoscroller.min.js'
    }

    bs3theme{
        resource url: 'css/themeTruncated.css'
    }

    contextmenu{
        resource url: 'js/jquery.contextMenu.js'
        resource url: 'css/jquery.contextMenu.css'
    }
}