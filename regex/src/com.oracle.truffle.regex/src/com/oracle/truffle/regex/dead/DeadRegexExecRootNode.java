/*
 * Copyright (c) 2016, 2019, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package com.oracle.truffle.regex.dead;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.regex.RegexExecRootNode;
import com.oracle.truffle.regex.RegexLanguage;
import com.oracle.truffle.regex.RegexSource;
import com.oracle.truffle.regex.result.NoMatchResult;
import com.oracle.truffle.regex.result.RegexResult;

/**
 * This RegexNode is used for regular expressions that can never match, like /a^a/, /a\ba/, /(?=a)b/
 * etc.
 */
public final class DeadRegexExecRootNode extends RegexExecRootNode {

    public DeadRegexExecRootNode(RegexLanguage language, RegexSource source) {
        super(language, source, false);
    }

    @Override
    protected RegexResult execute(VirtualFrame frame, Object input, int fromIndex) {
        return NoMatchResult.getInstance();
    }

    @Override
    protected String getEngineLabel() {
        return "dead";
    }
}
