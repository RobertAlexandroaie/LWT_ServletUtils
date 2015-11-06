package lwt.lab.utils;

import java.util.Map;

class TagBuilder {
    private TagBuilder() {
    };

    public static String appendTag(String tag, String value, Map<String, String> attributes) {
	StringBuilder builder = new StringBuilder();
	builder.append("<" + tag);
	appendAttributes(attributes, builder);
	builder.append(">");
	builder.append(value);
	builder.append("</" + tag + ">");
	return builder.toString();
    }

    private static void appendAttributes(Map<String, String> attributes, StringBuilder builder) {
	if(attributes != null && !attributes.isEmpty()) {
	    for(String attribute: attributes.keySet()) {
		builder.append(" " + attribute+"=\""+attributes.get(attribute)+"\"");
	    }
	}
    }
    
    public static String appendTag(String tag, String value) {
	return appendTag(tag, value, null);
    }

    public static String appendStylesheet(String cssPath) {
	return "<link rel=\"stylesheet\" href=\""+cssPath+"\" type=\"text/css\"/>";
    }
}
