/**
 * Copyright 2010 The Apache Software Foundation
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hbase.regionserver.handler;

import org.apache.hadoop.hbase.HRegionInfo;
import org.apache.hadoop.hbase.regionserver.RegionServer;

/**
 * Handles closing of the root region on a region server.
 */
public class CloseMetaHandler extends CloseRegionHandler {
  // Called when master tells us shutdown a region via close rpc
  public CloseMetaHandler(RegionServer server, HRegionInfo regionInfo) {
    this(server, regionInfo, false, true);
  }

  // Called when regionserver determines its to go down; not master orchestrated
  public CloseMetaHandler(RegionServer server, HRegionInfo regionInfo,
      final boolean abort, final boolean zk) {
    super(server, regionInfo, abort, zk, EventType.M2RS_CLOSE_META);
  }
}