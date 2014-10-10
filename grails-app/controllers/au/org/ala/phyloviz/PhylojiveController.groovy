package au.org.ala.phyloviz

import grails.transaction.Transactional
/**
 * Created by Temi Varghese on 19/06/2014.
 */
@Transactional(readOnly = true)
class PhylojiveController {
    /**
     * returns a tree in the format supported by phylojive.
     * formats - newick or nexml or json
     *
     */
    def getTree(){
        render (contentType: "text/plain", text: '<nex:nexml xmlns:nex="http://www.nexml.org/2009" \
            xmlns="http://www.nexml.org/2009" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#" \
            xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#" xmlns:skos="http://www.w3.org/2004/02/skos/core#" \
            xmlns:tb="http://purl.org/phylo/treebase/2.0/terms#" xmlns:xsd="http://www.w3.org/2001/XMLSchema#" \
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" generator="org.nexml.model.impl.DocumentImpl" \
            id="S1144" version="0.9" xml:base="http://purl.org/phylo/treebase/phylows/study/TB2:">  \
            <otus about="#Tls11489" id="Tls11489" label="TaxonLabelSet11489" xml:base="http://purl.org/phylo/treebase/\
            phylows/taxon/TB2:">    <meta content="Mapped from TreeBASE schema using org.cipres.treebase.domain.nexus.\
            nexml.NexmlOTUWriter@557c9372 $Rev: 1040 $" datatype="xsd:string" id="meta6107" property="skos:historyNote"\
             xsi:type="nex:LiteralMeta"/>    <otu about="#Tl7619" id="Tl7619" label="Megadyptes antipodes">      \
            <meta content="17144" datatype="xsd:long" id="meta6113" property="tb:identifier.taxon" xsi:type="nex:\
            LiteralMeta"/>      <meta content="40166" datatype="xsd:long" id="meta6112" property="tb:identifier.\
            taxonVariant" xsi:type="nex:LiteralMeta"/>      <meta href="http://purl.uniprot.org/taxonomy/37085"\
             id="meta6111" rel="skos:closeMatch" xsi:type="nex:ResourceMeta"/>      <meta href="http://www.ubio.org/\
            authority/metadata.php?lsid=urn:lsid:ubio.org:namebank:3851890" id="meta6110" rel="skos:closeMatch"\
             xsi:type="nex:ResourceMeta"/>      <meta href="http://purl.org/phylo/treebase/phylows/study/TB2:S1144" \
            id="meta6109" rel="rdfs:isDefinedBy" xsi:type="nex:ResourceMeta"/>    </otu>    <otu about="#Tl7615" \
            id="Tl7615" label="Diomedea epomophora">      <meta content="9133" datatype="xsd:long" id="meta6119"\
             property="tb:identifier.taxon" xsi:type="nex:LiteralMeta"/>      <meta content="21955" datatype="xsd:long"\
             id="meta6118" property="tb:identifier.taxonVariant" xsi:type="nex:LiteralMeta"/>      <meta href="http://\
            purl.uniprot.org/taxonomy/37070" id="meta6117" rel="skos:closeMatch" xsi:type="nex:ResourceMeta"/>      \
            <meta href="http://www.ubio.org/authority/metadata.php?lsid=urn:lsid:ubio.org:namebank:3851985" \
            id="meta6116" rel="skos:closeMatch" xsi:type="nex:ResourceMeta"/>      <meta href="http://purl.org/phylo/\
            treebase/phylows/study/TB2:S1144" id="meta6115" rel="rdfs:isDefinedBy" xsi:type="nex:ResourceMeta"/>    \
            </otu>    <otu about="#Tl145916" id="Tl145916" label="Phalacrocorax varius">      <meta content="21625" \
            datatype="xsd:long" id="meta6125" property="tb:identifier.taxon" xsi:type="nex:LiteralMeta"/>      \
            <meta content="50318" datatype="xsd:long" id="meta6124" property="tb:identifier.taxonVariant" xsi:type="nex\
            :LiteralMeta"/>      <meta href="http://purl.uniprot.org/taxonomy/146621" id="meta6123" rel="skos:closeMatc\
            h" xsi:type="nex:ResourceMeta"/>      <meta href="http://www.ubio.org/authority/metadata.php?lsid=urn:lsid:\
            ubio.org:namebank:3851713" id="meta6122" rel="skos:closeMatch" xsi:type="nex:ResourceMeta"/>      \
            <meta href="http://purl.org/phylo/treebase/phylows/study/TB2:S1144" id="meta6121" rel="rdfs:isDefinedBy"' +
            ' xsi:type="nex:ResourceMeta"/>    </otu>    <otu about="#Tl145925" id="Tl145925" label="Pelecanus occide' +
            'ntalis">      <meta content="20806" datatype="xsd:long" id="meta6131" property="tb:identifier.taxon" xsi:' +
                'type="nex:LiteralMeta"/>      <meta content="48446" datatype="xsd:long" id="meta6130" property="' +
                'tb:identifier.taxonVariant" xsi:type="nex:LiteralMeta"/>      <meta href="http://purl.uniprot.org/t' +
                'axonomy/37043" id="meta6129" rel="skos:closeMatch" xsi:type="nex:ResourceMeta"/>      <meta href="h' +
                'ttp://www.ubio.org/authority/metadata.php?lsid=urn:lsid:ubio.org:namebank:3851846" id="meta6128" rel=' +
                '"skos:closeMatch" xsi:type="nex:ResourceMeta"/>      <meta href="http://purl.org/phylo/treebase/phylows' +
                '/study/TB2:S1144" id="meta6127" rel="rdfs:isDefinedBy" xsi:type="nex:ResourceMeta"/>    </otu>   ' +
                ' <otu about="#Tl145919" id="Tl145919" label="Morus serrator">      <meta content="18208" datatype="' +
                'xsd:long" id="meta6137" property="tb:identifier.taxon" xsi:type="nex:LiteralMeta"/>      <meta' +
                ' content="42571" datatype="xsd:long" id="meta6136" property="tb:identifier.taxonVariant" xsi:ty' +
                'pe="nex:LiteralMeta"/>      <meta href="http://purl.uniprot.org/taxonomy/57658" id="meta6135" re' +
                'l="skos:closeMatch" xsi:type="nex:ResourceMeta"/>      <meta href="http://www.ubio.org/authority/met' +
                'adata.php?lsid=urn:lsid:ubio.org:namebank:3851691" id="meta6134" rel="skos:closeMatch" xsi:type="' +
                'nex:ResourceMeta"/>      <meta href="http://purl.org/phylo/treebase/phylows/study/TB2:S1144" id=' +
                '"meta6133" rel="rdfs:isDefinedBy" xsi:type="nex:ResourceMeta"/>    </otu>    <otu about="#Tl14592' +
                '1" id="Tl145921" label="Anhinga novaehollandiae">      <meta content="1629" datatype="xsd:long" ' +
                'id="meta6143" property="tb:identifier.taxon" xsi:type="nex:LiteralMeta"/>      <meta content="4' +
                '079" datatype="xsd:long" id="meta6142" property="tb:identifier.taxonVariant" xsi:type="nex:Liter' +
                'alMeta"/>      <meta href="http://purl.uniprot.org/taxonomy/9213" id="meta6141" rel="skos:closeMa' +
                'tch" xsi:type="nex:ResourceMeta"/>      <meta href="http://www.ubio.org/authority/metadata.php?l' +
                'sid=urn:lsid:ubio.org:namebank:3851700" id="meta6140" rel="skos:closeMatch" xsi:type="nex:Resour' +
                'ceMeta"/>      <meta href="http://purl.org/phylo/treebase/phylows/study/TB2:S1144" id="meta6139" ' +
                'rel="rdfs:isDefinedBy" xsi:type="nex:ResourceMeta"/>    </otu>    <otu about="#Tl145926" id="Tl1459' +
                '26" label="Phaethon rubricauda">      <meta content="21592" datatype="xsd:long" id="meta6149" prop' +
                'erty="tb:identifier.taxon" xsi:type="nex:LiteralMeta"/>      <meta content="50227" datatype="xsd' +
                ':long" id="meta6148" property="tb:identifier.taxonVariant" xsi:type="nex:LiteralMeta"/>      <meta' +
                ' href="http://purl.uniprot.org/taxonomy/57073" id="meta6147" rel="skos:closeMatch" xsi:type="nex:R' +
                'esourceMeta"/>      <meta href="http://www.ubio.org/authority/metadata.php?lsid=urn:lsid:ubio.org:' +
                'namebank:3851686" id="meta6146" rel="skos:closeMatch" xsi:type="nex:ResourceMeta"/>      <meta hre' +
                'f="http://purl.org/phylo/treebase/phylows/study/TB2:S1144" id="meta6145" rel="rdfs:isDefinedBy" xs' +
                'i:type="nex:ResourceMeta"/>    </otu>    <otu about="#Tl145922" id="Tl145922" label="Phaethon lept' +
                'urus">      <meta content="21591" datatype="xsd:long" id="meta6155" property="tb:identifier.taxon"' +
                ' xsi:type="nex:LiteralMeta"/>      <meta content="50226" datatype="xsd:long" id="meta6154" proper' +
                'ty="tb:identifier.taxonVariant" xsi:type="nex:LiteralMeta"/>      <meta href="http://purl.uniprot' +
                '.org/taxonomy/97097" id="meta6153" rel="skos:closeMatch" xsi:type="nex:ResourceMeta"/>      <meta ' +
                'href="http://www.ubio.org/authority/metadata.php?lsid=urn:lsid:ubio.org:namebank:3851687" id="meta' +
                '6152" rel="skos:closeMatch" xsi:type="nex:ResourceMeta"/>      <meta href="http://purl.org/phylo/t' +
                'reebase/phylows/study/TB2:S1144" id="meta6151" rel="rdfs:isDefinedBy" xsi:type="nex:ResourceMeta"/' +
                '>    </otu>    <otu about="#Tl59143" id="Tl59143" label="Phaethon aethereus">      <meta content="' +
                '21590" datatype="xsd:long" id="meta6161" property="tb:identifier.taxon" xsi:type="nex:LiteralMeta"/' +
                '>      <meta content="50224" datatype="xsd:long" id="meta6160" property="tb:identifier.taxonVariant' +
                '" xsi:type="nex:LiteralMeta"/>      <meta href="http://purl.uniprot.org/taxonomy/37045" id="meta6159' +
                '' +
                '" rel="skos:closeMatch" xsi:type="nex:ResourceMeta"/>      <meta href="http://www.ubio.org/authority' +
                '/metadata.php?lsid=urn:lsid:ubio.org:namebank:3851685" id="meta6158" rel="skos:closeMatch" xsi:type=' +
                '"nex:ResourceMeta"/>      <meta href="http://purl.org/phylo/treebase/phylows/study/TB2:S1144" id="me' +
                'ta6157" rel="rdfs:isDefinedBy" xsi:type="nex:ResourceMeta"/>    </otu>    <otu about="#Tl145914" id=' +
                '"Tl145914" label="Fregata minor">      <meta content="11465" datatype="xsd:long" id="meta6167" prope' +
                'rty="tb:identifier.taxon" xsi:type="nex:LiteralMeta"/>      <meta content="27383" datatype="xsd:long' +
                '" id="meta6166" property="tb:identifier.taxonVariant" xsi:type="nex:LiteralMeta"/>      <meta href=' +
                '"http://purl.uniprot.org/taxonomy/57241" id="meta6165" rel="skos:closeMatch" xsi:type="nex:Resource' +
                '' +
                'Meta"/>      <meta href="http://www.ubio.org/authority/metadata.php?lsid=urn:lsid:ubio.org:namebank' +
                ':3851876" id="meta6164" rel="skos:closeMatch" xsi:type="nex:ResourceMeta"/>      <meta href="http:/' +
                '/purl.org/phylo/treebase/phylows/study/TB2:S1144" id="meta6163" rel="rdfs:isDefinedBy" xsi:type="ne' +
                'x:ResourceMeta"/>    </otu>    <otu about="#Tl145924" id="Tl145924" label="Fregata magnificens">    ' +
                '  <meta content="11464" datatype="xsd:long" id="meta6173" property="tb:identifier.taxon" xsi:type="n' +
                'ex:LiteralMeta"/>      <meta content="27380" datatype="xsd:long" id="meta6172" property="tb:identifi' +
                'er.taxonVariant" xsi:type="nex:LiteralMeta"/>      <meta href="http://purl.uniprot.org/taxonomy/3704' +
                '2" id="meta6171" rel="skos:closeMatch" xsi:type="nex:ResourceMeta"/>      <meta href="http://www.ubi' +
                'o.org/authority/metadata.php?lsid=urn:lsid:ubio.org:namebank:3851874" id="meta6170" rel="skos:closeM' +
                'atch" xsi:type="nex:ResourceMeta"/>      <meta href="http://purl.org/phylo/treebase/phylows/study/TB' +
                '2:S1144" id="meta6169" rel="rdfs:isDefinedBy" xsi:type="nex:ResourceMeta"/>    </otu>    <otu about=' +
                '"#Tl59141" id="Tl59141" label="Fregata ariel">      <meta content="11463" datatype="xsd:long" id="me' +
                'ta6179" property="tb:identifier.taxon" xsi:type="nex:LiteralMeta"/>      <meta content="27377" datat' +
                'ype="xsd:long" id="meta6178" property="tb:identifier.taxonVariant" xsi:type="nex:LiteralMeta"/>     ' +
                ' <meta href="http://purl.uniprot.org/taxonomy/244446" id="meta6177" rel="skos:closeMatch" xsi:type="' +
                'nex:ResourceMeta"/>      <meta href="http://www.ubio.org/authority/metadata.php?lsid=urn:lsid:ubio.or' +
                'g:namebank:3851877" id="meta6176" rel="skos:closeMatch" xsi:type="nex:ResourceMeta"/>      <meta href' +
                '="http://purl.org/phylo/treebase/phylows/study/TB2:S1144" id="meta6175" rel="rdfs:isDefinedBy" xsi:ty' +
                'pe="nex:ResourceMeta"/>    </otu>    <otu about="#Tl59144" id="Tl59144" label="Fregata aquila">      ' +
                '<meta content="11462" datatype="xsd:long" id="meta6185" property="tb:identifier.taxon" xsi:type="nex:' +
                'LiteralMeta"/>      <meta content="27376" datatype="xsd:long" id="meta6184" property="tb:identifier.t' +
                'axonVariant" xsi:type="nex:LiteralMeta"/>      <meta href="http://purl.uniprot.org/taxonomy/244445" i' +
                'd="meta6183" rel="skos:closeMatch" xsi:type="nex:ResourceMeta"/>      <meta href="http://www.ubio.or' +
                'g/authority/metadata.php?lsid=urn:lsid:ubio.org:namebank:3851875" id="meta6182" rel="skos:closeMatc' +
                'h" xsi:type="nex:ResourceMeta"/>      <meta href="http://purl.org/phylo/treebase/phylows/study/TB' +
                '' +
                '2:S1144" id="meta6181" rel="rdfs:isDefinedBy" xsi:type="nex:ResourceMeta"/>    </otu>    <otu abo' +
                'ut="#Tl59142" id="Tl59142" label="Fregata andrewsi">      <meta content="11461" datatype="xsd:long" ' +
                'id="meta6191" property="tb:identifier.taxon" xsi:type="nex:LiteralMeta"/>      <meta content="27372' +
                '" datatype="xsd:long" id="meta6190" property="tb:identifier.taxonVariant" xsi:type="nex:LiteralMet' +
                'a"/>      <meta href="http://purl.uniprot.org/taxonomy/244444" id="meta6189" rel="skos:closeMatch"' +
                ' xsi:type="nex:ResourceMeta"/>      <meta href="http://www.ubio.org/authority/metadata.php?lsid=ur' +
                'n:lsid:ubio.org:namebank:3851878" id="meta6188" rel="skos:closeMatch" xsi:type="nex:ResourceMeta"/' +
                '>      <meta href="http://purl.org/phylo/treebase/phylows/study/TB2:S1144" id="meta6187" rel="rdfs' +
                ':isDefinedBy" xsi:type="nex:ResourceMeta"/>    </otu>  </otus>  <trees about="#trees6192" id="trees' +
                '6192" label="" otus="Tls11489" xml:base="http://purl.org/phylo/treebase/phylows/tree/TB2:">    <me' +
                'ta content="Mapped from TreeBASE schema using org.cipres.treebase.domain.nexus.nexml.NexmlTreeBloc' +
                'kWriter@d8fb683 $Rev: 1040 $" datatype="xsd:string" id="meta6193" property="skos:historyNote" xsi:t' +
                'ype="nex:LiteralMeta"/>    <tree about="#Tr221" id="Tr221" label="Fig. 1a" xsi:type="nex:FloatTree"' +
                '>      <meta content="14" datatype="xsd:integer" id="meta6199" property="tb:ntax.tree" xsi:type="ne' +
                'x:LiteralMeta"/>      <meta content="Unrated" datatype="xsd:string" id="meta6198" property="tb:qual' +
                'ity.tree" xsi:type="nex:LiteralMeta"/>      <meta content="Consensus" datatype="xsd:string" id="met' +
                'a6197" property="tb:type.tree" xsi:type="nex:LiteralMeta"/>      <meta content="Species Tree" dataty' +
                'pe="xsd:string" id="meta6196" property="tb:kind.tree" xsi:type="nex:LiteralMeta"/>      <meta href="' +
                'http://purl.org/phylo/treebase/phylows/study/TB2:S1144" id="meta6195" rel="rdfs:isDefinedBy" xsi:typ' +
                'e="nex:ResourceMeta"/>      <node id="Tn2809"/>      <node id="Tn2804"/>      <node id="Tn2802"/>   ' +
                '   <node id="Tn2794"/>      <node id="Tn2815"/>      <node id="Tn2808" label="Fregata andrewsi" otu="' +
                'Tl59142"/>      <node id="Tn2799" label="Fregata minor" otu="Tl145914"/>      <node id="Tn2813"/>    ' +
                '  <node id="Tn2806" label="Fregata aquila" otu="Tl59144"/>      <node id="Tn2796" label="Fregata magn' +
                '' +
                'ificens" otu="Tl145924"/>      <node id="Tn2810" label="Fregata ariel" otu="Tl59141"/>      <node id=' +
                '"Tn2805"/>      <node id="Tn2798" label="Phaethon aethereus" otu="Tl59143"/>      <node id="Tn2811"/' +
                '>      <node id="Tn2807" label="Phaethon lepturus" otu="Tl145922"/>      <node id="Tn2795" label="Pha' +
                'ethon rubricauda" otu="Tl145926"/>      <node id="Tn2800"/>      <node id="Tn2814"/>      <node id="T' +
                'n2812" label="Anhinga novaehollandiae" otu="Tl145921"/>      <node id="Tn2816" label="Morus serrator"' +
                ' otu="Tl145919"/>      <node id="Tn2803" label="Phalacrocorax varius" otu="Tl145916"/>      <node id' +
                '="Tn2797" label="Pelecanus occidentalis" otu="Tl145925"/>      <node id="Tn2817" label="Diomedea' +
                ' epomophora" otu="Tl7615"/>      <node id="Tn2801" label="Megadyptes antipodes" otu="Tl7619"/> ' +
                '     <edge id="edge6202" source="Tn2809" target="Tn2804"/>      <edge id="edge6204" source="Tn28' +
                '04" target="Tn2802"/>      <edge id="edge6206" source="Tn2802" target="Tn2794"/>      <edge id=' +
                '"edge6208" source="Tn2794" target="Tn2815"/>      <edge id="edge6210" source="Tn2815" target="T' +
                'n2808"/>      <edge id="edge6212" source="Tn2815" target="Tn2799"/>      <edge id="edge6214" so' +
                'urce="Tn2794" target="Tn2813"/>      <edge id="edge6216" source="Tn2813" target="Tn2806"/>     ' +
                ' <edge id="edge6218" source="Tn2813" target="Tn2796"/>      <edge id="edge6220" source="Tn2802"' +
                ' target="Tn2810"/>      <edge id="edge6222" source="Tn2804" target="Tn2805"/>      <edge id="ed' +
                'ge6224" source="Tn2805" target="Tn2798"/>      <edge id="edge6226" source="Tn2805" target="Tn28' +
                '11"/>      <edge id="edge6228" source="Tn2811" target="Tn2807"/>      <edge id="edge6230" sourc' +
                'e="Tn2811" target="Tn2795"/>      <edge id="edge6232" source="Tn2804" target="Tn2800"/>      <ed' +
                'ge id="edge6234" source="Tn2800" target="Tn2814"/>      <edge id="edge6236" source="Tn2814" targ' +
                'et="Tn2812"/>      <edge id="edge6238" source="Tn2814" target="Tn2816"/>      <edge id="edge624' +
                '0" source="Tn2800" target="Tn2803"/>      <edge id="edge6242" source="Tn2804" target="Tn2797"/>' +
                '      <edge id="edge6244" source="Tn2804" target="Tn2817"/>      <edge id="edge6246" source="Tn' +
                '2809" target="Tn2801"/>    </tree>  </trees></nex:nexml>')
    }
}
