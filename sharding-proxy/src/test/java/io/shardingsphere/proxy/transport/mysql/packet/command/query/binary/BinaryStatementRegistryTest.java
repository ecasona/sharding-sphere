/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.proxy.transport.mysql.packet.command.query.binary;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public final class BinaryStatementRegistryTest {
    
    private final String sql = "SELECT * FROM tbl WHERE id=?";
    
    @Before
    public void setUp() throws ReflectiveOperationException {
        Field statementIdAssignerField = BinaryStatementRegistry.class.getDeclaredField("statementIdAssigner");
        statementIdAssignerField.setAccessible(true);
        ((Map) statementIdAssignerField.get(BinaryStatementRegistry.getInstance())).clear();
        Field binaryStatementsField = BinaryStatementRegistry.class.getDeclaredField("binaryStatements");
        binaryStatementsField.setAccessible(true);
        ((Map) binaryStatementsField.get(BinaryStatementRegistry.getInstance())).clear();
        Field sequenceField = BinaryStatementRegistry.class.getDeclaredField("sequence");
        sequenceField.setAccessible(true);
        ((AtomicInteger) sequenceField.get(BinaryStatementRegistry.getInstance())).set(0);
    }
    
    @Test
    public void assertRegisterIfAbsent() {
        assertThat(BinaryStatementRegistry.getInstance().register(sql, 1), is(1));
        BinaryStatement actual = BinaryStatementRegistry.getInstance().getBinaryStatement(1);
        assertThat(actual.getSql(), is(sql));
        assertThat(actual.getParametersCount(), is(1));
    }
    
    @Test
    public void assertRegisterIfPresent() {
        assertThat(BinaryStatementRegistry.getInstance().register(sql, 1), is(1));
        assertThat(BinaryStatementRegistry.getInstance().register(sql, 1), is(1));
        BinaryStatement actual = BinaryStatementRegistry.getInstance().getBinaryStatement(1);
        assertThat(actual.getSql(), is(sql));
        assertThat(actual.getParametersCount(), is(1));
    }
}
