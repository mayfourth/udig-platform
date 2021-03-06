/* uDig - User Friendly Desktop Internet GIS client
 * http://udig.refractions.net
 * (C) 2004, Refractions Research Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * (http://www.eclipse.org/legal/epl-v10.html), and the Refractions BSD
 * License v1.0 (http://udig.refractions.net/files/bsd3-v10.html).
 */
package net.refractions.udig.project.internal.render.impl.renderercreator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import net.refractions.udig.project.ILayer;
import net.refractions.udig.project.internal.render.Renderer;
import net.refractions.udig.project.render.AbstractRenderMetrics;
import net.refractions.udig.project.render.IRenderContext;
import net.refractions.udig.project.render.IRenderMetricsFactory;
import net.refractions.udig.project.render.IRenderer;

import org.geotools.util.Range;

/**
 * For testing.  Creates a normal Renderer.  Accepts resources that resolve to RendererCreatorTestObjForSingleRenderer objects.
 * @author Jesse
 * @since 1.1.0
 */
public class SingleRenderMetricsFactory implements IRenderMetricsFactory {


    public class SingleRenderMetrics extends AbstractRenderMetrics {

        public SingleRenderMetrics( IRenderContext context, IRenderMetricsFactory factory ) {
            super(context, factory, new ArrayList<String>());
        }

        public boolean canAddLayer( ILayer layer ) {
            return layer.hasResource(RendererCreatorTestObjForSingleRenderer.class);
        }

        public boolean canStyle( String styleID, Object value ) {
            return value instanceof SingleRendererStyleContent;
        }

        public Renderer createRenderer() {
            return new SingleRenderer();
        }
        

        @SuppressWarnings("unchecked")
        public Set<Range<Double>> getValidScaleRanges() {
            return new HashSet<Range<Double>>();
        }
    }

    public boolean canRender( IRenderContext context ) throws IOException {
        return context.getGeoResource().canResolve(RendererCreatorTestObjForSingleRenderer.class);
    }

    public AbstractRenderMetrics createMetrics( IRenderContext context ) {
        return new SingleRenderMetrics(context, this);
    }

    public Class< ? extends IRenderer> getRendererType() {
        return SingleRenderer.class;
    }

}
