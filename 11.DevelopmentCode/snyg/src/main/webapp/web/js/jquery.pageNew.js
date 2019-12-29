  (function(){
  var ms = {
    init:function(obj,args){ 
      return (function(){ 
        ms.fillHtml(obj,args); 
        ms.bindEvent(obj,args); 
      })(); 
    },
    fillHtml:function(obj,args){ 
      return (function(){
        obj.empty();
        //上一页
        if(args.current > 1){
          obj.append('<a prevPage="prevPage"><  上一页</a>');
        }else{
          obj.append('<a prevPage=""><  上一页</a>');
        }
        if(args.current != 1 && args.current >= 4 && args.pageCount != 4){ 
          obj.append('<a page="1">'+1+'</a>');
        } 
        if(args.current-2 > 2 && args.current <= args.pageCount && args.pageCount > 5){ 
          obj.append('...');
        } 
        var start = args.current -2,end = args.current+2; 
        if((start > 1 && args.current < 4)||args.current == 1){ 
          end++; 
        } 
        if(args.current > args.pageCount-4 && args.current >= args.pageCount){ 
          start--; 
        }
        for (;start <= end; start++) { 
          if(start <= args.pageCount && start >= 1){ 
            if(start != args.current){ 
              obj.append('<a page="'+ start +'">'+ start +'</a>');
            }else{ 
              obj.append('<a class="current">'+ start +'</a>');
            }
          }
        } 
        if(args.current + 2 < args.pageCount - 1 && args.current >= 1 && args.pageCount > 5){ 
          obj.append('...');
        } 
        if(args.current != args.pageCount && args.current < args.pageCount -2 && args.pageCount != 4){ 
          obj.append('<a page="'+ args.pageCount +'">'+args.pageCount+'</a>');
        }
        if(args.current < args.pageCount){ 
          obj.append('<a nextPage="nextPage">下一页  ></a>');
        }else{
          obj.append('<a nextPage="">下一页  ></a>');
        } 
      })(); 
    },
    bindEvent:function(obj,args){ 
      return (function(){ 
        obj.on("click","a[page]",function(){
          var current = parseInt($(this).attr("page"));
          ms.fillHtml(obj,{"current":current,"pageCount":args.pageCount}); 
          if(typeof(args.backFn)=="function"){ 
            args.backFn(current); 
          } 
        });
        //上一页
        obj.on("click","a[prevPage]",function(){
          if($(this).attr('prevPage') == 'prevPage')
          {
            var current = parseInt(obj.children(".current").text());
            ms.fillHtml(obj,{"current":current-1,"pageCount":args.pageCount});
            if(typeof(args.backFn)=="function"){
              args.backFn(current-1);
            }
          }
        });
        //下一页
        obj.on("click","a[nextPage]",function(){
          if($(this).attr('nextPage') == 'nextPage')
          {
            var current = parseInt(obj.children(".current").text());
            ms.fillHtml(obj,{"current":current+1,"pageCount":args.pageCount});
            if(typeof(args.backFn)=="function"){
              args.backFn(current+1);
            }
          }
        }); 
      })(); 
    } 
  } 
  $.fn.createPage = function(options){ 
    var args = $.extend({ 
      pageCount : 10, 
      current : 1, 
      backFn : function(){} 
    },options); 
    ms.init(this,args); 
  } 
})(jQuery);