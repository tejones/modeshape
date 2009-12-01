/*
 * JBoss DNA (http://www.jboss.org/dna)
 * See the COPYRIGHT.txt file distributed with this work for information
 * regarding copyright ownership.  Some portions may be licensed
 * to Red Hat, Inc. under one or more contributor license agreements.
 * See the AUTHORS.txt file in the distribution for a full listing of 
 * individual contributors.
 *
 * JBoss DNA is free software. Unless otherwise indicated, all code in JBoss DNA
 * is licensed to you under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 * 
 * JBoss DNA is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.dna.graph.query.model;

import net.jcip.annotations.Immutable;
import org.jboss.dna.common.util.CheckArg;

/**
 * A dynamic operand that evaluates to the lower-case representation of the supplied operand, used in a {@link Comparison}
 * constraint.
 */
@Immutable
public class LowerCase extends DynamicOperand {
    private static final long serialVersionUID = 1L;

    private final DynamicOperand operand;

    /**
     * Create a dynamic operand that evaluates to the lower-case representation of the supplied operand.
     * 
     * @param operand the operand that is to be lower-cased
     */
    public LowerCase( DynamicOperand operand ) {
        CheckArg.isNotNull(operand, "operand");
        this.operand = operand;
    }

    /**
     * Get the dynamic operand that is to be lower-cased.
     * 
     * @return the dynamic operand; never null
     */
    public final DynamicOperand getOperand() {
        return operand;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.jboss.dna.graph.query.model.DynamicOperand#getSelectorName()
     */
    @Override
    public SelectorName getSelectorName() {
        return operand.getSelectorName();
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return Visitors.readable(this);
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return operand.hashCode();
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals( Object obj ) {
        if (obj == this) return true;
        if (obj instanceof LowerCase) {
            LowerCase that = (LowerCase)obj;
            return this.operand.equals(that.operand);
        }
        return false;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.jboss.dna.graph.query.model.Visitable#accept(org.jboss.dna.graph.query.model.Visitor)
     */
    public void accept( Visitor visitor ) {
        visitor.visit(this);
    }
}
