/**
 * Created by Temi Varghese on 8/08/2014.
 */
var utils={
    autocomplete:function( elementId, list, displayId, configId ){
        jQuery("#"+elementId ).autocomplete( {
            source: list,
            matchSubset: false,
            minChars: 3,
            scroll: true,
            max: 10,
            selectFirst: false,
            dataType: 'jsonp',
            formatMatch: function( row , i ){
                return row.label;
            },
            select: function( et , selection ){
                $(document.getElementById( configId ) ).attr( 'value', selection.item.value );
                $( document.getElementById(  displayId  ) ).attr( 'value', selection.item.label );
            }
        });
        // the autocomplete box is appearing below the modal dialog. below logic to prevent it.
        $(".ui-autocomplete").css('z-index',1051);
    },
    addTemplate: function( dest, tmpId){
//        $('#'+dest).append( $('#'+tmpId).html() )
        return $($('#'+tmpId).html()).appendTo('#'+dest)
    },
    download:function( data ){
        $.ajax({
            url:'http://localhost:8080/phylolink/download',
            method:'POST',
            data:{
                json: JSON.stringify( data )
            }
        })
    },
    modalDialog:function( opts ){
        var options= {
            id: opts.id || 'modalDialog',
            remote: opts.url,
            height: opts.height || 500,
            width: opts.width || 560
        }
        var mSel = "#_tmpModal";
        var html = $(mSel).html();
        var modal = $(html).appendTo( "body" );
        ko.applyBindings(opts, modal[0]);

        var sel = '#'+ options.id;
        modal.find('.modal-body').css( 'max-height', options.height +'px');
        $( sel ).on("hidden", function(){
           $( sel ).remove();
        });
        modal.modal( options )
    }
}
