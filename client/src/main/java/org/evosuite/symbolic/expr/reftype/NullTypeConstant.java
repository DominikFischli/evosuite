/*
 * Copyright (C) 2010-2018 Gordon Fraser, Andrea Arcuri and EvoSuite
 * contributors
 *
 * This file is part of EvoSuite.
 *
 * EvoSuite is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3.0 of the License, or
 * (at your option) any later version.
 *
 * EvoSuite is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with EvoSuite. If not, see <http://www.gnu.org/licenses/>.
 */
package org.evosuite.symbolic.expr.reftype;

import org.evosuite.symbolic.expr.ExpressionVisitor;
import org.evosuite.symbolic.expr.reftype.type.NullType;
import org.evosuite.symbolic.vm.heap.SymbolicHeap;
import org.objectweb.asm.Type;

/**
 * Symbolic representation of the null type.
 * There should be only one instance of this object.
 *
 * @author Ignacio Lebrero
 */
public final class NullTypeConstant extends ReferenceTypeConstant {

    public static NullTypeConstant instance;

    public static synchronized NullTypeConstant getInstance() {
        if (instance == null) {
            instance = new NullTypeConstant();
        }

        return instance;
    }

    private NullTypeConstant() {
        super(Type.getType(NullType.class), SymbolicHeap.NULL_TYPE_ID);
    }

    @Override
    public <K, V> K accept(ExpressionVisitor<K, V> v, V arg) {
        return v.visit(this, arg);
    }
}