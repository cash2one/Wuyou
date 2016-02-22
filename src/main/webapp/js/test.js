/**
 * 
 */
document.write("test");
function word(text) {
	var i = 0,
		length = text.length;
	var value = "";
	
	for(; i < length; i++) {
		value += "\\u" + (text.charCodeAt(i)).toString(16)
	}
	
	return value;
}