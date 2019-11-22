//##########分页跳转JS
var strUserAgent = navigator.userAgent.toLowerCase();
var isIE = strUserAgent.indexOf("msie") > -1;
var isNS6 = strUserAgent.indexOf("netscape6") > -1;

var reValidChars = /\d/;
var reValidString = /^\d*$/;
var reKeyboardChars = /[\x00\x03\x08\x0D\x16\x18\x1A]/;
var reClipboardChars = /[cvxz]/i;

function maskChange(objEvent) {
	var objInput;
	maskKeyPress(objEvent);

	if (isIE) {
		objInput = objEvent.srcElement;
	} else {
		objInput = objEvent.target;
	}

	if (!isValid(objInput.value)) {
		objInput.value = objInput.validValue || "";
		objInput.focus();
		objInput.select();
	} else {
		objInput.validValue = objInput.value;
	}
}

function maskKeyPress(objEvent) {
	var iKeyCode, strKey, objInput;

	if (isIE) {
		iKeyCode = objEvent.keyCode;
		objInput = objEvent.srcElement;
	} else {
		iKeyCode = objEvent.which;
		objInput = objEvent.target;
	}

	strKey = String.fromCharCode(iKeyCode);

	if (isValid(objInput.value)) {
		objInput.validValue = objInput.value;
		if (!reValidChars.test(strKey) && !reKeyboardChars.test(strKey)
				&& !checkClipboardCode(objEvent, strKey)) {
			// alert("Invalid Character Detected!\nKeyCode = " + iKeyCode +
			// "\nCharacter =" + strKey);
			return false;
		}
	} else {
		// alert("Invalid Data");
		return false;
	}
}

function checkClipboardCode(objEvent, strKey) {
	if (isNS6)
		return objEvent.ctrlKey && reClipboardChars.test(strKey);
	else
		return false;
}

function isValid(strValue) {
	return reValidString.test(strValue) || strValue.length == 0;
}
//##########分页跳转JS