/* uDig - User Friendly Desktop Internet GIS client
 * http://udig.refractions.net
 * (C) 2004, Refractions Research Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * (http://www.eclipse.org/legal/epl-v10.html), and the Refractions BSD
 * License v1.0 (http://udig.refractions.net/files/bsd3-v10.html).
 */
package net.refractions.udig.ui.operations;

class CacheBlock extends TestingAbstractOpFilter {

    boolean result;

    public CacheBlock( boolean result ) {
        super();
        this.result = result;
    }

    public boolean accept( Object object ) {
        return result;
    }

    public boolean canCacheResult() {
        return true;
    }

    public boolean isBlocking() {
        return true;
    }
}