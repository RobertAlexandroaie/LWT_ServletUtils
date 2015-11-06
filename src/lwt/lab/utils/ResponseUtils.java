package lwt.lab.utils;

import java.util.Map;

/** Some simple time savers. Static methods. */

public class ResponseUtils {

    private static String HTML5Doctype() {
	return "<!DOCTYPE html>\n";
    }

    public static String titledHTML(String title) {
	return titleBodyStyleHTML(title, null, "./css/styles.css");
    }

    public static String cleanHTML() {
	return titleBodyStyleHTML(null, null, "./css/styles.css");
    }

    public static String titleBodyStyleHTML(String title, String body, String cssPath) {
	StringBuilder htmlBuilder = new StringBuilder();
	String appendedBody = TagBuilder.appendTag("body", body != null ? body : "");
	String appendedTitle = TagBuilder.appendTag("title", title != null ? title : "");
	String appendedStyle = TagBuilder.appendStylesheet(cssPath);
	String appendedHead = TagBuilder.appendTag("head", appendedTitle + appendedStyle);
	String appendedHTML = TagBuilder.appendTag("html", appendedHead + appendedBody);
	htmlBuilder.append(HTML5Doctype()).append(appendedHTML);
	return htmlBuilder.toString();
    }
    
    public static String titleBodyHTML(String title, String body) {
	return titleBodyStyleHTML(title, body, "./css/styles.css");
    }

    public static String appendUL(String[] data) {
	return TagBuilder.appendTag("ul", appendLIElements(data));
    }

    private static String appendLIElements(String[] liData) {
	StringBuilder liBuilder = new StringBuilder();
	for (int i = 0; i < liData.length; i++) {
	    liBuilder.append(TagBuilder.appendTag("li", liData[i]));
	}
	return liBuilder.toString();
    }

    public static String appendTableWithHeader(String[][] data, String[] headerLabels) {
	StringBuilder tableBuilder = new StringBuilder();
	if (data[0].length == headerLabels.length) {
	    StringBuilder colBuilder = new StringBuilder();
	    StringBuilder rowBuilder = new StringBuilder();

	    appendTH(headerLabels, colBuilder, rowBuilder);
	    appendTableData(data, tableBuilder, rowBuilder);
	}

	return tableBuilder.toString();
    }

    private static void appendTableData(String[][] data, StringBuilder tableBuilder, StringBuilder rowBuilder) {
	StringBuilder colBuilder;
	for (int i = 0; i < data.length; i++) {
	    colBuilder = new StringBuilder();
	    for (int j = 0; j < data[i].length; j++) {
		appendTD(data, colBuilder, i, j);
	    }
	    appendTR(rowBuilder, colBuilder);
	}
	tableBuilder.append(TagBuilder.appendTag("table", rowBuilder.toString()));
    }

    private static void appendTR(StringBuilder rowBuilder, StringBuilder colBuilder) {
	rowBuilder.append(TagBuilder.appendTag("tr", colBuilder.toString()));
    }

    private static void appendTD(String[][] data, StringBuilder colBuilder, int i, int j) {
	colBuilder.append(TagBuilder.appendTag("td", data[i][j]));
    }

    private static void appendTH(String[] headerLabels, StringBuilder colBuilder, StringBuilder rowBuilder) {
	for (int i = 0; i < headerLabels.length; i++) {
	    colBuilder.append(TagBuilder.appendTag("th", headerLabels[i]));
	}
	appendTR(rowBuilder, colBuilder);
    }

    private ResponseUtils() {
    } // Uninstantiatable class

    public static String appendP(String paragraph) {
	return TagBuilder.appendTag("p", paragraph);
    }

    public static String appendA(String content, Map<String, String> attributes) {
	return TagBuilder.appendTag("a", content);
    }
}
