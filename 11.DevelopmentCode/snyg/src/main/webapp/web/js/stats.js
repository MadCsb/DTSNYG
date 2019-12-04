function getCookie(c_name) {
    if (document.cookie.length > 0) {
        c_start = document.cookie.indexOf(c_name + "=")
        if (c_start != -1) {
            c_start = c_start + c_name.length + 1
            c_end = document.cookie.indexOf(";", c_start)
            if (c_end == -1)
                c_end = document.cookie.length
            return unescape(document.cookie.substring(c_start, c_end))
        }
    }
    return ""
}

function getQueryString(e) {
    var t = new RegExp("(^|&)" + e + "=([^&]*)(&|$)");
    var a = window.location.search.substr(1).match(t);
    if (a != null) return a[2];
    return ""
}

function setCookie(name, value) {
    var exp = new Date();
    exp.setFullYear()
    exp.setTime(exp.setFullYear(exp.getFullYear()+20)); //20年后过期
    document.cookie = name + "=" + encodeURIComponent(value)
        + ";expires=" + exp.toGMTString() + ";path=/";
    return true;
};

// post请求
// 格式化post 传递的数据
function postDataFormat(obj) {
    if (typeof obj != "object") {
        alert("输入的参数必须是对象");
        return;
    }

    // 支持有FormData的浏览器（Firefox 4+ , Safari 5+, Chrome和Android 3+版的Webkit）
    if (typeof FormData == "function") {
        var data = new FormData();
        for (var attr in obj) {
            data.append(attr, obj[attr]);
        }
        return data;
    } else {
        // 不支持FormData的浏览器的处理
        var arr = new Array();
        var i = 0;
        for (var attr in obj) {
            arr[i] = encodeURIComponent(attr) + "=" + encodeURIComponent(obj[attr]);
            i++;
        }
        return arr.join("&");
    }
}



if(typeof _sld_stats!='undefined' && _sld_stats){
    var exp = new Date();

    var stats_data = {};
    stats_data.arrive = parseInt(exp.getTime()/1000); //访问时间
    stats_data.userAgent = navigator.userAgent; //浏览器标识
    stats_data.end =  _sld_stats.end ? _sld_stats.end : /Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent) ? '0' :  '1';  //移动端还是pc端
    stats_data.refer = document.referrer; //来源地址
    stats_data.title = document.title;  //页面标题
    stats_data.url = location.href;   //当前页地址
    stats_data.uid = _sld_stats.uid;  //会员id  未登陆：0
    stats_data.gid = _sld_stats.gid;   //商品id  非商品详情：0
    stats_data.gids = _sld_stats.gids;   //商品曝光数组
    stats_data.region = getCookie('sld_stat_visitor_region');
    stats_data.channel = getCookie('sld_stat_visitor_channel');

    var api_url = location.origin+'/index.php?app=stats_handle';


    var xmlhttp = null;  // 创建异步请求
    if(window.ActiveXObject){ //如果是IE浏览器
        xmlhttp =  new ActiveXObject("Microsoft.XMLHTTP");
    }else if(window.XMLHttpRequest){ //非IE浏览器
        xmlhttp = new XMLHttpRequest();
    }

    if(typeof FormData == "undefined") {
        xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    }

    //页面触达
    window.onload = function (ev) {

        stats_data.dur = ev.timeStamp;  //页面打开时间
        stats_data.is_new = 0;  //新老访客

        var s_channel = getQueryString('s_channel');
        if(s_channel){
            setCookie('sld_stat_visitor_channel',s_channel);
            stats_data.channel = s_channel;
        }

        //支持 localStorage 的话
        if(window.Storage && window.localStorage && window.localStorage instanceof Storage){
            if(!localStorage.getItem('sld_stat_visitor_key')){
                localStorage.setItem('sld_stat_visitor_key',getCookie('PHPSESSID'));
                stats_data.is_new = 1;
                stats_data.key = getCookie('PHPSESSID');
            }else{
                stats_data.key = localStorage.getItem('sld_stat_visitor_key');
            }
            // localStorage.setItem('sld_stat_visitor',JSON.stringify(data));
        }else{
            if(!getCookie('sld_stat_visitor_key')){
                setCookie('sld_stat_visitor_key',getCookie('PHPSESSID'));
                stats_data.is_new = 1;
                stats_data.key = getCookie('PHPSESSID');
            }else{
                stats_data.key = getCookie('sld_stat_visitor_key');
            }
            // setCookie('sld_stat_visitor',JSON.stringify(data));
        }

        xmlhttp.open('post',api_url,true);  // 使用GET方法获取hello.txt文件
        xmlhttp.send(postDataFormat(stats_data));  // 使用GET方法获取hello.txt文件
    }


    //页面跳出
    window.onbeforeunload = function (ev) {
            var new_data = {};
            new_data.stay = ev.timeStamp - stats_data.dur;
            new_data.key = stats_data.key;
            new_data.arrive = stats_data.arrive;

            xmlhttp.open('post', api_url + '&mod=change_val', true);  // 使用GET方法获取hello.txt文件
            xmlhttp.send(postDataFormat(new_data));  // 使用GET方法获取hello.txt文件
    }
}