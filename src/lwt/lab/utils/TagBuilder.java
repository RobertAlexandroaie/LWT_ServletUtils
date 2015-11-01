package lwt.lab.utils;

class TagBuilder {
    private TagBuilder() {
    };

    public static String appendTag(String tag, String value) {
	StringBuilder builder = new StringBuilder();
	builder.append("<" + tag + ">");
	builder.append(value);
	builder.append("</" + tag + ">");
	return builder.toString();
    }

    public static String appendStylesheet(String cssPath) {
	return "<link rel=\"stylesheet\" href=\""+cssPath+"\" type=\"text/css\"/>";
    }
}
