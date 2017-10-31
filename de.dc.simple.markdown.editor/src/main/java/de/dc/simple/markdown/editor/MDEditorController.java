package de.dc.simple.markdown.editor;
import java.util.Arrays;
import java.util.List;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebView;

public class MDEditorController {

    @FXML
    protected WebView htmlEditor;

    @FXML
    protected TextArea textEditor;

	private Parser parser;
	private HtmlRenderer renderer;

	public void initialize() {
		List<Extension> extensions = Arrays.asList(TablesExtension.create());
		parser = Parser.builder().extensions(extensions).build();
		renderer = HtmlRenderer.builder().extensions(extensions).build();
		htmlEditor.setVisible(true);
	}
	
    @FXML
    protected void onTextEditorPressed(KeyEvent event) {
    	Node document = parser.parse(textEditor.getText());
    	String html = renderer.render(document);
    	htmlEditor.getEngine().loadContent("<html>"+html+"</html>", "text/html");
    };
}
