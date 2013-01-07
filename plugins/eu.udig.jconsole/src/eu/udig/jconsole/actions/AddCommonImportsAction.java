/*
 * uDig - User Friendly Desktop Internet GIS client
 * (C) HydroloGIS - www.hydrologis.com 
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * (http://www.eclipse.org/legal/epl-v10.html), and the HydroloGIS BSD
 * License v1.0 (http://udig.refractions.net/files/hsd3-v10.html).
 */
package eu.udig.jconsole.actions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.texteditor.TextEditorAction;

import eu.udig.jconsole.JConsolePlugin;
import eu.udig.jconsole.JavaEditor;
import eu.udig.jconsole.JavaEditorMessages;

/**
 * A template insertion action.
 * 
 * @author Andrea Antonello (www.hydrologis.com)
 */
public class AddCommonImportsAction extends TextEditorAction {

    public static final String TEMPLATE = "icons/template.gif"; //$NON-NLS-1$

    /**
     * Constructs and updates the action.
     */
    public AddCommonImportsAction() {
        super(JavaEditorMessages.getResourceBundle(), "Template.", null); //$NON-NLS-1$

        ImageDescriptor id = AbstractUIPlugin.imageDescriptorFromPlugin(JConsolePlugin.PLUGIN_ID, TEMPLATE);
        setImageDescriptor(id);
    }

    public void run() {
        JavaEditor editor = (JavaEditor) getTextEditor();

        IDocument doc = editor.getDocumentProvider().getDocument(editor.getEditorInput());

        String text = doc.get();

        StringBuilder sb = new StringBuilder();
        sb.append("import geoscript.geom.*\n");
        sb.append("import geoscript.proj.*\n");
        sb.append("import geoscript.render.*\n");
        sb.append("import geoscript.layer.*\n");
        sb.append("import geoscript.style.*\n");
        sb.append("import geoscript.viewer.*\n");

        StringBuilder finalSb = new StringBuilder();
        finalSb.append(sb.toString());
        finalSb.append("\n");
        finalSb.append(text);

        // URL templateUrl =
        // Platform.getBundle(JConsolePlugin.PLUGIN_ID).getResource("templates/simtemplate.groovy");
        // String templatePath = null;
        // try {
        // templatePath = FileLocator.toFileURL(templateUrl).getPath();
        // BufferedReader br = null;
        // try {
        // br = new BufferedReader(new FileReader(templatePath));
        // String line = null;
        // while( (line = br.readLine()) != null ) {
        // finalSb.append(line).append("\n");
        // }
        // } finally {
        // br.close();
        // }

        doc.set(finalSb.toString());

        // } catch (IOException e) {
        // e.printStackTrace();
        // }
    }

}