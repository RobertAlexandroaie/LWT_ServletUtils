package lwt.lab.utils;

/** Some simple time savers. Static methods. */

public class ResponseUtils {
	
	private static String HTML5Doctype() {
		return "<!DOCTYPE html>\n";
	}
	
	public static String titledHTML(String title) {
		return titleAndBodyHTML(title, null);
	}

	public static String cleanHTML() {
		return titleAndBodyHTML(null,null);
	}
	
	public static String titleAndBodyHTML(String title, String body) {
	    StringBuilder htmlBuilder = new StringBuilder();
	    htmlBuilder.append(HTML5Doctype())
		    	.append("<html>\n")
			.append("\t<head>\n")
			.append(title != null ? "\t\t<title>" + title + "</title>\n" : "")
			.append("\t</head>\n")
			.append("\t<body>\n")
			.append(body != null ? body + "\n" : "")
			.append("\t</body>\n")
			.append("</html>");
	    return htmlBuilder.toString();
	}
	
	private ResponseUtils() {
	} // Uninstantiatable class
}
