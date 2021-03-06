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

package io.shardingsphere.proxy.transport.mysql.packet.command;

import io.shardingsphere.proxy.transport.mysql.packet.command.admin.UnsupportedCommandPacketTest;
import io.shardingsphere.proxy.transport.mysql.packet.command.admin.initdb.ComInitDbPacketTest;
import io.shardingsphere.proxy.transport.mysql.packet.command.admin.ping.ComPingPacketTest;
import io.shardingsphere.proxy.transport.mysql.packet.command.admin.quit.ComQuitPacketTest;
import io.shardingsphere.proxy.transport.mysql.packet.command.query.ColumnDefinition41PacketTest;
import io.shardingsphere.proxy.transport.mysql.packet.command.query.FieldCountPacketTest;
import io.shardingsphere.proxy.transport.mysql.packet.command.query.QueryResponsePacketsTest;
import io.shardingsphere.proxy.transport.mysql.packet.command.query.binary.BinaryStatementRegistryTest;
import io.shardingsphere.proxy.transport.mysql.packet.command.query.text.TextResultSetRowPacketTest;
import io.shardingsphere.proxy.transport.mysql.packet.command.query.text.fieldlist.ComFieldListPacketTest;
import io.shardingsphere.proxy.transport.mysql.packet.command.query.text.query.ComQueryPacketTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        CommandPacketTypeTest.class, 
        CommandPacketFactoryTest.class, 
        CommandResponsePacketsTest.class, 
        QueryResponsePacketsTest.class, 
        BinaryStatementRegistryTest.class, 
        FieldCountPacketTest.class,
        ColumnDefinition41PacketTest.class,
        TextResultSetRowPacketTest.class,
        ComFieldListPacketTest.class,
        ComQueryPacketTest.class, 
        
        ComInitDbPacketTest.class, 
        ComPingPacketTest.class, 
        ComQuitPacketTest.class, 
        UnsupportedCommandPacketTest.class
})
public final class AllMySQLCommandPacketTests {
}
