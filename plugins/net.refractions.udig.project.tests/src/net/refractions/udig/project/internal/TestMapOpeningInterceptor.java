/* uDig - User Friendly Desktop Internet GIS client
 * http://udig.refractions.net
 * (C) 2004, Refractions Research Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * (http://www.eclipse.org/legal/epl-v10.html), and the Refractions BSD
 * License v1.0 (http://udig.refractions.net/files/bsd3-v10.html).
 */
package net.refractions.udig.project.internal;

import org.junit.Ignore;

import net.refractions.udig.project.interceptor.MapInterceptor;

/**
 * prints message when map is opened.
 * @author Jesse
 * @since 1.1.0
 */
@Ignore
public class TestMapOpeningInterceptor implements MapInterceptor {

    public static Map mapOpening;

    public TestMapOpeningInterceptor() {
        super();
    }

    public void run( Map map ) {
        mapOpening=map;
//        System.out.println(map.getName()+" is being opened.  This is a test interceptor"); //$NON-NLS-1$
    }

}
