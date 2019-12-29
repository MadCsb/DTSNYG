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
          obj.append('<li><span prevPage="prevPage">上一页</span></li>');
        }else{
          obj.append('<li><span prevPage="">上一页</span></li>');
        }

        if(args.current != 1 && args.current >= 4 && args.pageCount != 4){ 
          obj.append('<li><span page="1">'+1+'</span></li>');
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
              obj.append('<li><span page="'+ start +'">'+ start +'</span></li>');
            }else{ 
              obj.append('<li><span class="currentpage">'+ start +'</span></li>');
            }
          }
        } 
        if(args.current + 2 < args.pageCount - 1 && args.current >= 1 && args.pageCount > 5){ 
          obj.append('...');
        } 
        if(args.current != args.pageCount && args.current < args.pageCount -2 && args.pageCount != 4){ 
          obj.append('<li><span page="'+ args.pageCount +'">'+args.pageCount+'</span></li>');
        }
        if(args.current < args.pageCount){ 
          obj.append('<li><span nextPage="nextPage">下一页</span></li>');
        }else{
          obj.append('<li><span nextPage="">下一页</span></li>');
        } 
      })(); 
    },
    bindEvent:function(obj,args){ 
      return (function(){
        obj.find("span[page]").click(function(){
          var current = parseInt($(this).attr("page"));
          ms.fillHtml(obj,{"current":current,"pageCount":args.pageCount});
          if(typeof(args.backFn)=="function"){
            args.backFn(current);
          }
        });
        //上一页
        obj.find("span[prevPage]").click(function(){
          if($(this).attr('prevPage') == 'prevPage')
          {
            var current = parseInt(obj.find("span.currentpage").text());
            ms.fillHtml(obj,{"current":current-1,"pageCount":args.pageCount});
            if(typeof(args.backFn)=="function"){
              args.backFn(current-1);
            }
          }
        });

        //下一页
        obj.find("span[nextPage]").click(function(){
          if($(this).attr('nextPage') == 'nextPage')
          {
            var current = parseInt(obj.find("span.currentpage").text());
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