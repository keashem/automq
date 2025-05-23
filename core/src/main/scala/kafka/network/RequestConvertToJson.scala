/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package kafka.network

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node._
import org.apache.kafka.common.message._
import org.apache.kafka.common.network.ClientInformation
import org.apache.kafka.common.requests._
import org.apache.kafka.common.requests.s3._
import org.apache.kafka.network.Session

object RequestConvertToJson {
  def request(request: AbstractRequest): JsonNode = {
    request match {
      case req: AddOffsetsToTxnRequest => AddOffsetsToTxnRequestDataJsonConverter.write(req.data, request.version)
      case req: AddPartitionsToTxnRequest => AddPartitionsToTxnRequestDataJsonConverter.write(req.data, request.version)
      case req: AllocateProducerIdsRequest => AllocateProducerIdsRequestDataJsonConverter.write(req.data, request.version)
      case req: AlterClientQuotasRequest => AlterClientQuotasRequestDataJsonConverter.write(req.data, request.version)
      case req: AlterConfigsRequest => AlterConfigsRequestDataJsonConverter.write(req.data, request.version)
      case req: AlterPartitionReassignmentsRequest => AlterPartitionReassignmentsRequestDataJsonConverter.write(req.data, request.version)
      case req: AlterPartitionRequest => AlterPartitionRequestDataJsonConverter.write(req.data, request.version)
      case req: AlterReplicaLogDirsRequest => AlterReplicaLogDirsRequestDataJsonConverter.write(req.data, request.version)
      case res: AlterUserScramCredentialsRequest => AlterUserScramCredentialsRequestDataJsonConverter.write(res.data, request.version)
      case req: ApiVersionsRequest => ApiVersionsRequestDataJsonConverter.write(req.data, request.version)
      case req: AssignReplicasToDirsRequest => AssignReplicasToDirsRequestDataJsonConverter.write(req.data, request.version)
      case req: BeginQuorumEpochRequest => BeginQuorumEpochRequestDataJsonConverter.write(req.data, request.version)
      case req: BrokerHeartbeatRequest => BrokerHeartbeatRequestDataJsonConverter.write(req.data, request.version)
      case req: BrokerRegistrationRequest => BrokerRegistrationRequestDataJsonConverter.write(req.data, request.version)
      case req: ConsumerGroupDescribeRequest => ConsumerGroupDescribeRequestDataJsonConverter.write(req.data, request.version)
      case req: ConsumerGroupHeartbeatRequest => ConsumerGroupHeartbeatRequestDataJsonConverter.write(req.data, request.version)
      case req: ControlledShutdownRequest => ControlledShutdownRequestDataJsonConverter.write(req.data, request.version)
      case req: ControllerRegistrationRequest => ControllerRegistrationRequestDataJsonConverter.write(req.data, request.version)
      case req: CreateAclsRequest => CreateAclsRequestDataJsonConverter.write(req.data, request.version)
      case req: CreateDelegationTokenRequest => CreateDelegationTokenRequestDataJsonConverter.write(req.data, request.version)
      case req: CreatePartitionsRequest => CreatePartitionsRequestDataJsonConverter.write(req.data, request.version)
      case req: CreateTopicsRequest => CreateTopicsRequestDataJsonConverter.write(req.data, request.version)
      case req: DeleteAclsRequest => DeleteAclsRequestDataJsonConverter.write(req.data, request.version)
      case req: DeleteGroupsRequest => DeleteGroupsRequestDataJsonConverter.write(req.data, request.version)
      case req: DeleteRecordsRequest => DeleteRecordsRequestDataJsonConverter.write(req.data, request.version)
      case req: DeleteShareGroupStateRequest => DeleteShareGroupStateRequestDataJsonConverter.write(req.data, request.version)
      case req: DeleteTopicsRequest => DeleteTopicsRequestDataJsonConverter.write(req.data, request.version)
      case req: DescribeAclsRequest => DescribeAclsRequestDataJsonConverter.write(req.data, request.version)
      case req: DescribeClientQuotasRequest => DescribeClientQuotasRequestDataJsonConverter.write(req.data, request.version)
      case req: DescribeClusterRequest => DescribeClusterRequestDataJsonConverter.write(req.data, request.version)
      case req: DescribeConfigsRequest => DescribeConfigsRequestDataJsonConverter.write(req.data, request.version)
      case req: DescribeDelegationTokenRequest => DescribeDelegationTokenRequestDataJsonConverter.write(req.data, request.version)
      case req: DescribeGroupsRequest => DescribeGroupsRequestDataJsonConverter.write(req.data, request.version)
      case req: DescribeLogDirsRequest => DescribeLogDirsRequestDataJsonConverter.write(req.data, request.version)
      case req: DescribeProducersRequest => DescribeProducersRequestDataJsonConverter.write(req.data, request.version)
      case req: DescribeQuorumRequest => DescribeQuorumRequestDataJsonConverter.write(req.data, request.version)
      case res: DescribeTopicPartitionsRequest => DescribeTopicPartitionsRequestDataJsonConverter.write(res.data, request.version)
      case req: DescribeTransactionsRequest => DescribeTransactionsRequestDataJsonConverter.write(req.data, request.version)
      case res: DescribeUserScramCredentialsRequest => DescribeUserScramCredentialsRequestDataJsonConverter.write(res.data, request.version)
      case req: ElectLeadersRequest => ElectLeadersRequestDataJsonConverter.write(req.data, request.version)
      case req: EndQuorumEpochRequest => EndQuorumEpochRequestDataJsonConverter.write(req.data, request.version)
      case req: EndTxnRequest => EndTxnRequestDataJsonConverter.write(req.data, request.version)
      case req: EnvelopeRequest => EnvelopeRequestDataJsonConverter.write(req.data, request.version)
      case req: ExpireDelegationTokenRequest => ExpireDelegationTokenRequestDataJsonConverter.write(req.data, request.version)
      case req: FetchRequest => FetchRequestDataJsonConverter.write(req.data, request.version)
      case req: FetchSnapshotRequest => FetchSnapshotRequestDataJsonConverter.write(req.data, request.version)
      case req: FindCoordinatorRequest => FindCoordinatorRequestDataJsonConverter.write(req.data, request.version)
      case req: GetTelemetrySubscriptionsRequest => GetTelemetrySubscriptionsRequestDataJsonConverter.write(req.data, request.version)
      case req: HeartbeatRequest => HeartbeatRequestDataJsonConverter.write(req.data, request.version)
      case req: IncrementalAlterConfigsRequest => IncrementalAlterConfigsRequestDataJsonConverter.write(req.data, request.version)
      case req: InitializeShareGroupStateRequest => InitializeShareGroupStateRequestDataJsonConverter.write(req.data, request.version)
      case req: InitProducerIdRequest => InitProducerIdRequestDataJsonConverter.write(req.data, request.version)
      case req: JoinGroupRequest => JoinGroupRequestDataJsonConverter.write(req.data, request.version)
      case req: LeaderAndIsrRequest => LeaderAndIsrRequestDataJsonConverter.write(req.data, request.version)
      case req: LeaveGroupRequest => LeaveGroupRequestDataJsonConverter.write(req.data, request.version)
      case req: ListClientMetricsResourcesRequest => ListClientMetricsResourcesRequestDataJsonConverter.write(req.data, request.version)
      case req: ListGroupsRequest => ListGroupsRequestDataJsonConverter.write(req.data, request.version)
      case req: ListOffsetsRequest => ListOffsetsRequestDataJsonConverter.write(req.data, request.version)
      case req: ListPartitionReassignmentsRequest => ListPartitionReassignmentsRequestDataJsonConverter.write(req.data, request.version)
      case req: ListTransactionsRequest => ListTransactionsRequestDataJsonConverter.write(req.data, request.version)
      case req: MetadataRequest => MetadataRequestDataJsonConverter.write(req.data, request.version)
      case req: OffsetCommitRequest => OffsetCommitRequestDataJsonConverter.write(req.data, request.version)
      case req: OffsetDeleteRequest => OffsetDeleteRequestDataJsonConverter.write(req.data, request.version)
      case req: OffsetFetchRequest => OffsetFetchRequestDataJsonConverter.write(req.data, request.version)
      case req: OffsetsForLeaderEpochRequest => OffsetForLeaderEpochRequestDataJsonConverter.write(req.data, request.version)
      case req: ProduceRequest => ProduceRequestDataJsonConverter.write(req.data, request.version, false)
      case req: PushTelemetryRequest => PushTelemetryRequestDataJsonConverter.write(req.data, request.version)
      case req: ReadShareGroupStateRequest => ReadShareGroupStateRequestDataJsonConverter.write(req.data, request.version)
      case req: ReadShareGroupStateSummaryRequest => ReadShareGroupStateSummaryRequestDataJsonConverter.write(req.data, request.version)
      case req: RenewDelegationTokenRequest => RenewDelegationTokenRequestDataJsonConverter.write(req.data, request.version)
      case req: SaslAuthenticateRequest => SaslAuthenticateRequestDataJsonConverter.write(req.data, request.version)
      case req: SaslHandshakeRequest => SaslHandshakeRequestDataJsonConverter.write(req.data, request.version)
      case req: ShareAcknowledgeRequest => ShareAcknowledgeRequestDataJsonConverter.write(req.data, request.version)
      case req: ShareFetchRequest => ShareFetchRequestDataJsonConverter.write(req.data, request.version)
      case req: ShareGroupDescribeRequest => ShareGroupDescribeRequestDataJsonConverter.write(req.data, request.version)
      case req: ShareGroupHeartbeatRequest => ShareGroupHeartbeatRequestDataJsonConverter.write(req.data, request.version)
      case req: StopReplicaRequest => StopReplicaRequestDataJsonConverter.write(req.data, request.version)
      case req: SyncGroupRequest => SyncGroupRequestDataJsonConverter.write(req.data, request.version)
      case req: TxnOffsetCommitRequest => TxnOffsetCommitRequestDataJsonConverter.write(req.data, request.version)
      case req: UnregisterBrokerRequest => UnregisterBrokerRequestDataJsonConverter.write(req.data, request.version)
      case req: UpdateFeaturesRequest => UpdateFeaturesRequestDataJsonConverter.write(req.data, request.version)
      case req: UpdateMetadataRequest => UpdateMetadataRequestDataJsonConverter.write(req.data, request.version)
      case req: VoteRequest => VoteRequestDataJsonConverter.write(req.data, request.version)
      case req: WriteShareGroupStateRequest => WriteShareGroupStateRequestDataJsonConverter.write(req.data, request.version)
      case req: WriteTxnMarkersRequest => WriteTxnMarkersRequestDataJsonConverter.write(req.data, request.version)

      // AutoMQ for Kafka inject start
      case req: CreateStreamsRequest => CreateStreamsRequestDataJsonConverter.write(req.data, request.version)
      case req: DeleteStreamsRequest => DeleteStreamsRequestDataJsonConverter.write(req.data, request.version)
      case req: OpenStreamsRequest => OpenStreamsRequestDataJsonConverter.write(req.data, request.version)
      case req: CloseStreamsRequest => CloseStreamsRequestDataJsonConverter.write(req.data, request.version)
      case req: TrimStreamsRequest => TrimStreamsRequestDataJsonConverter.write(req.data, request.version)
      case req: PrepareS3ObjectRequest => PrepareS3ObjectRequestDataJsonConverter.write(req.data, request.version)
      case req: CommitStreamSetObjectRequest => CommitStreamSetObjectRequestDataJsonConverter.write(req.data, request.version)
      case req: CommitStreamObjectRequest => CommitStreamObjectRequestDataJsonConverter.write(req.data, request.version)
      case req: GetOpeningStreamsRequest => GetOpeningStreamsRequestDataJsonConverter.write(req.data, request.version)
      case req: GetKVsRequest => GetKVsRequestDataJsonConverter.write(req.data, request.version)
      case req: PutKVsRequest => PutKVsRequestDataJsonConverter.write(req.data, request.version)
      case req: DeleteKVsRequest => DeleteKVsRequestDataJsonConverter.write(req.data, request.version)
      case req: AutomqRegisterNodeRequest => AutomqRegisterNodeRequestDataJsonConverter.write(req.data, request.version)
      case req: AutomqGetNodesRequest => AutomqGetNodesRequestDataJsonConverter.write(req.data, request.version)
      case req: AutomqZoneRouterRequest => AutomqZoneRouterRequestDataJsonConverter.write(req.data, request.version)
      case req: AutomqGetPartitionSnapshotRequest => AutomqGetPartitionSnapshotRequestDataJsonConverter.write(req.data, request.version)
      case req: GetNextNodeIdRequest => GetNextNodeIdRequestDataJsonConverter.write(req.data, request.version)
      case req: DescribeStreamsRequest => DescribeStreamsRequestDataJsonConverter.write(req.data, request.version)
      // AutoMQ for Kafka inject end
      
      case req: AddRaftVoterRequest => AddRaftVoterRequestDataJsonConverter.write(req.data, request.version)
      case req: RemoveRaftVoterRequest => RemoveRaftVoterRequestDataJsonConverter.write(req.data, request.version)
      case req: UpdateRaftVoterRequest => UpdateRaftVoterRequestDataJsonConverter.write(req.data, request.version)
      case _ => throw new IllegalStateException(s"ApiKey ${request.apiKey} is not currently handled in `request`, the " +
        "code should be updated to do so.")
    }
  }

  def response(response: AbstractResponse, version: Short): JsonNode = {
    response match {
      case res: AddOffsetsToTxnResponse => AddOffsetsToTxnResponseDataJsonConverter.write(res.data, version)
      case res: AddPartitionsToTxnResponse => AddPartitionsToTxnResponseDataJsonConverter.write(res.data, version)
      case res: AllocateProducerIdsResponse => AllocateProducerIdsResponseDataJsonConverter.write(res.data, version)
      case res: AlterClientQuotasResponse => AlterClientQuotasResponseDataJsonConverter.write(res.data, version)
      case res: AlterConfigsResponse => AlterConfigsResponseDataJsonConverter.write(res.data, version)
      case res: AlterPartitionReassignmentsResponse => AlterPartitionReassignmentsResponseDataJsonConverter.write(res.data, version)
      case res: AlterPartitionResponse => AlterPartitionResponseDataJsonConverter.write(res.data, version)
      case res: AlterReplicaLogDirsResponse => AlterReplicaLogDirsResponseDataJsonConverter.write(res.data, version)
      case res: AlterUserScramCredentialsResponse => AlterUserScramCredentialsResponseDataJsonConverter.write(res.data, version)
      case res: ApiVersionsResponse => ApiVersionsResponseDataJsonConverter.write(res.data, version)
      case res: AssignReplicasToDirsResponse => AssignReplicasToDirsResponseDataJsonConverter.write(res.data, version)
      case res: BeginQuorumEpochResponse => BeginQuorumEpochResponseDataJsonConverter.write(res.data, version)
      case res: BrokerHeartbeatResponse => BrokerHeartbeatResponseDataJsonConverter.write(res.data, version)
      case res: BrokerRegistrationResponse => BrokerRegistrationResponseDataJsonConverter.write(res.data, version)
      case res: ConsumerGroupDescribeResponse => ConsumerGroupDescribeResponseDataJsonConverter.write(res.data, version)
      case res: ConsumerGroupHeartbeatResponse => ConsumerGroupHeartbeatResponseDataJsonConverter.write(res.data, version)
      case res: ControlledShutdownResponse => ControlledShutdownResponseDataJsonConverter.write(res.data, version)
      case req: ControllerRegistrationResponse => ControllerRegistrationResponseDataJsonConverter.write(req.data, version)
      case res: CreateAclsResponse => CreateAclsResponseDataJsonConverter.write(res.data, version)
      case res: CreateDelegationTokenResponse => CreateDelegationTokenResponseDataJsonConverter.write(res.data, version)
      case res: CreatePartitionsResponse => CreatePartitionsResponseDataJsonConverter.write(res.data, version)
      case res: CreateTopicsResponse => CreateTopicsResponseDataJsonConverter.write(res.data, version)
      case res: DeleteAclsResponse => DeleteAclsResponseDataJsonConverter.write(res.data, version)
      case res: DeleteGroupsResponse => DeleteGroupsResponseDataJsonConverter.write(res.data, version)
      case res: DeleteRecordsResponse => DeleteRecordsResponseDataJsonConverter.write(res.data, version)
      case res: DeleteShareGroupStateResponse => DeleteShareGroupStateResponseDataJsonConverter.write(res.data, version)
      case res: DeleteTopicsResponse => DeleteTopicsResponseDataJsonConverter.write(res.data, version)
      case res: DescribeAclsResponse => DescribeAclsResponseDataJsonConverter.write(res.data, version)
      case res: DescribeClientQuotasResponse => DescribeClientQuotasResponseDataJsonConverter.write(res.data, version)
      case res: DescribeClusterResponse => DescribeClusterResponseDataJsonConverter.write(res.data, version)
      case res: DescribeConfigsResponse => DescribeConfigsResponseDataJsonConverter.write(res.data, version)
      case res: DescribeDelegationTokenResponse => DescribeDelegationTokenResponseDataJsonConverter.write(res.data, version)
      case res: DescribeGroupsResponse => DescribeGroupsResponseDataJsonConverter.write(res.data, version)
      case res: DescribeLogDirsResponse => DescribeLogDirsResponseDataJsonConverter.write(res.data, version)
      case res: DescribeProducersResponse => DescribeProducersResponseDataJsonConverter.write(res.data, version)
      case res: DescribeQuorumResponse => DescribeQuorumResponseDataJsonConverter.write(res.data, version)
      case res: DescribeTopicPartitionsResponse => DescribeTopicPartitionsResponseDataJsonConverter.write(res.data, version)
      case res: DescribeTransactionsResponse => DescribeTransactionsResponseDataJsonConverter.write(res.data, version)
      case res: DescribeUserScramCredentialsResponse => DescribeUserScramCredentialsResponseDataJsonConverter.write(res.data, version)
      case res: ElectLeadersResponse => ElectLeadersResponseDataJsonConverter.write(res.data, version)
      case res: EndQuorumEpochResponse => EndQuorumEpochResponseDataJsonConverter.write(res.data, version)
      case res: EndTxnResponse => EndTxnResponseDataJsonConverter.write(res.data, version)
      case res: EnvelopeResponse => EnvelopeResponseDataJsonConverter.write(res.data, version)
      case res: ExpireDelegationTokenResponse => ExpireDelegationTokenResponseDataJsonConverter.write(res.data, version)
      case res: FetchResponse => FetchResponseDataJsonConverter.write(res.data, version, false)
      case res: FetchSnapshotResponse => FetchSnapshotResponseDataJsonConverter.write(res.data, version)
      case res: FindCoordinatorResponse => FindCoordinatorResponseDataJsonConverter.write(res.data, version)
      case res: GetTelemetrySubscriptionsResponse => GetTelemetrySubscriptionsResponseDataJsonConverter.write(res.data, version)
      case res: HeartbeatResponse => HeartbeatResponseDataJsonConverter.write(res.data, version)
      case res: IncrementalAlterConfigsResponse => IncrementalAlterConfigsResponseDataJsonConverter.write(res.data, version)
      case res: InitializeShareGroupStateResponse => InitializeShareGroupStateResponseDataJsonConverter.write(res.data, version)
      case res: InitProducerIdResponse => InitProducerIdResponseDataJsonConverter.write(res.data, version)
      case res: JoinGroupResponse => JoinGroupResponseDataJsonConverter.write(res.data, version)
      case res: LeaderAndIsrResponse => LeaderAndIsrResponseDataJsonConverter.write(res.data, version)
      case res: LeaveGroupResponse => LeaveGroupResponseDataJsonConverter.write(res.data, version)
      case res: ListClientMetricsResourcesResponse => ListClientMetricsResourcesResponseDataJsonConverter.write(res.data, version)
      case res: ListGroupsResponse => ListGroupsResponseDataJsonConverter.write(res.data, version)
      case res: ListOffsetsResponse => ListOffsetsResponseDataJsonConverter.write(res.data, version)
      case res: ListPartitionReassignmentsResponse => ListPartitionReassignmentsResponseDataJsonConverter.write(res.data, version)
      case res: ListTransactionsResponse => ListTransactionsResponseDataJsonConverter.write(res.data, version)
      case res: MetadataResponse => MetadataResponseDataJsonConverter.write(res.data, version)
      case res: OffsetCommitResponse => OffsetCommitResponseDataJsonConverter.write(res.data, version)
      case res: OffsetDeleteResponse => OffsetDeleteResponseDataJsonConverter.write(res.data, version)
      case res: OffsetFetchResponse => OffsetFetchResponseDataJsonConverter.write(res.data, version)
      case res: OffsetsForLeaderEpochResponse => OffsetForLeaderEpochResponseDataJsonConverter.write(res.data, version)
      case res: ProduceResponse => ProduceResponseDataJsonConverter.write(res.data, version)
      case res: PushTelemetryResponse => PushTelemetryResponseDataJsonConverter.write(res.data, version)
      case res: ReadShareGroupStateResponse => ReadShareGroupStateResponseDataJsonConverter.write(res.data, version)
      case res: ReadShareGroupStateSummaryResponse => ReadShareGroupStateSummaryResponseDataJsonConverter.write(res.data, version)
      case res: RenewDelegationTokenResponse => RenewDelegationTokenResponseDataJsonConverter.write(res.data, version)
      case res: SaslAuthenticateResponse => SaslAuthenticateResponseDataJsonConverter.write(res.data, version)
      case res: SaslHandshakeResponse => SaslHandshakeResponseDataJsonConverter.write(res.data, version)
      case res: ShareAcknowledgeResponse => ShareAcknowledgeResponseDataJsonConverter.write(res.data, version)
      case res: ShareFetchResponse => ShareFetchResponseDataJsonConverter.write(res.data, version)
      case res: ShareGroupDescribeResponse => ShareGroupDescribeResponseDataJsonConverter.write(res.data, version)
      case res: ShareGroupHeartbeatResponse => ShareGroupHeartbeatResponseDataJsonConverter.write(res.data, version)
      case res: StopReplicaResponse => StopReplicaResponseDataJsonConverter.write(res.data, version)
      case res: SyncGroupResponse => SyncGroupResponseDataJsonConverter.write(res.data, version)
      case res: TxnOffsetCommitResponse => TxnOffsetCommitResponseDataJsonConverter.write(res.data, version)
      case res: UnregisterBrokerResponse => UnregisterBrokerResponseDataJsonConverter.write(res.data, version)
      case res: UpdateFeaturesResponse => UpdateFeaturesResponseDataJsonConverter.write(res.data, version)
      case res: UpdateMetadataResponse => UpdateMetadataResponseDataJsonConverter.write(res.data, version)
      case res: VoteResponse => VoteResponseDataJsonConverter.write(res.data, version)
      case res: WriteShareGroupStateResponse => WriteShareGroupStateResponseDataJsonConverter.write(res.data, version)
      case res: WriteTxnMarkersResponse => WriteTxnMarkersResponseDataJsonConverter.write(res.data, version)

      // AutoMQ for Kafka inject start
      case res: CreateStreamsResponse => CreateStreamsResponseDataJsonConverter.write(res.data, version)
      case res: DeleteStreamsResponse => DeleteStreamsResponseDataJsonConverter.write(res.data, version)
      case res: OpenStreamsResponse => OpenStreamsResponseDataJsonConverter.write(res.data, version)
      case res: CloseStreamsResponse => CloseStreamsResponseDataJsonConverter.write(res.data, version)
      case res: TrimStreamsResponse => TrimStreamsResponseDataJsonConverter.write(res.data, version)
      case res: PrepareS3ObjectResponse => PrepareS3ObjectResponseDataJsonConverter.write(res.data, version)
      case res: CommitStreamSetObjectResponse => CommitStreamSetObjectResponseDataJsonConverter.write(res.data, version)
      case res: CommitStreamObjectResponse => CommitStreamObjectResponseDataJsonConverter.write(res.data, version)
      case res: GetOpeningStreamsResponse => GetOpeningStreamsResponseDataJsonConverter.write(res.data, version)
      case res: GetKVsResponse => GetKVsResponseDataJsonConverter.write(res.data, version)
      case res: PutKVsResponse => PutKVsResponseDataJsonConverter.write(res.data, version)
      case res: DeleteKVsResponse => DeleteKVsResponseDataJsonConverter.write(res.data, version)
      case res: AutomqRegisterNodeResponse => AutomqRegisterNodeResponseDataJsonConverter.write(res.data, version)
      case res: AutomqGetNodesResponse => AutomqGetNodesResponseDataJsonConverter.write(res.data, version)
      case res: GetNextNodeIdResponse => GetNextNodeIdResponseDataJsonConverter.write(res.data, version)
      case res: AutomqZoneRouterResponse => AutomqZoneRouterResponseDataJsonConverter.write(res.data, version)
      case res: DescribeStreamsResponse => DescribeStreamsResponseDataJsonConverter.write(res.data, version)
      // AutoMQ for Kafka inject end
      
      case res: AddRaftVoterResponse => AddRaftVoterResponseDataJsonConverter.write(res.data, version)
      case res: RemoveRaftVoterResponse => RemoveRaftVoterResponseDataJsonConverter.write(res.data, version)
      case res: UpdateRaftVoterResponse => UpdateRaftVoterResponseDataJsonConverter.write(res.data, version)
      case _ => throw new IllegalStateException(s"ApiKey ${response.apiKey} is not currently handled in `response`, the " +
        "code should be updated to do so.")
    }
  }

  def requestHeaderNode(header: RequestHeader): JsonNode = {
    val node = RequestHeaderDataJsonConverter.write(header.data, header.headerVersion, false).asInstanceOf[ObjectNode]
    node.set("requestApiKeyName", new TextNode(header.apiKey.toString))
    if (header.apiKey().isVersionDeprecated(header.apiVersion()))
      node.set("requestApiVersionDeprecated", BooleanNode.TRUE)
    node
  }

  def requestDesc(header: RequestHeader, requestNode: Option[JsonNode], isForwarded: Boolean): JsonNode = {
    val node = new ObjectNode(JsonNodeFactory.instance)
    node.set("isForwarded", if (isForwarded) BooleanNode.TRUE else BooleanNode.FALSE)
    node.set("requestHeader", requestHeaderNode(header))
    node.set("request", requestNode.getOrElse(new TextNode("")))
    node
  }

  def clientInfoNode(clientInfo: ClientInformation): JsonNode = {
    val node = new ObjectNode(JsonNodeFactory.instance)
    node.set("softwareName", new TextNode(clientInfo.softwareName))
    node.set("softwareVersion", new TextNode(clientInfo.softwareVersion))
    node
  }

  def requestDescMetrics(header: RequestHeader, requestNode: Option[JsonNode], responseNode: Option[JsonNode],
                         context: RequestContext, session: Session, isForwarded: Boolean,
                         totalTimeMs: Double, requestQueueTimeMs: Double, apiLocalTimeMs: Double,
                         apiRemoteTimeMs: Double, apiThrottleTimeMs: Long, responseQueueTimeMs: Double,
                         responseSendTimeMs: Double, temporaryMemoryBytes: Long,
                         messageConversionsTimeMs: Double): JsonNode = {
    val node = requestDesc(header, requestNode, isForwarded).asInstanceOf[ObjectNode]
    node.set("response", responseNode.getOrElse(new TextNode("")))
    node.set("connection", new TextNode(context.connectionId))
    node.set("totalTimeMs", new DoubleNode(totalTimeMs))
    node.set("requestQueueTimeMs", new DoubleNode(requestQueueTimeMs))
    node.set("localTimeMs", new DoubleNode(apiLocalTimeMs))
    node.set("remoteTimeMs", new DoubleNode(apiRemoteTimeMs))
    node.set("throttleTimeMs", new LongNode(apiThrottleTimeMs))
    node.set("responseQueueTimeMs", new DoubleNode(responseQueueTimeMs))
    node.set("sendTimeMs", new DoubleNode(responseSendTimeMs))
    node.set("securityProtocol", new TextNode(context.securityProtocol.toString))
    node.set("principal", new TextNode(session.principal.toString))
    node.set("listener", new TextNode(context.listenerName.value))
    node.set("clientInformation", clientInfoNode(context.clientInformation))
    if (temporaryMemoryBytes > 0)
      node.set("temporaryMemoryBytes", new LongNode(temporaryMemoryBytes))
    if (messageConversionsTimeMs > 0)
      node.set("messageConversionsTime", new DoubleNode(messageConversionsTimeMs))
    node
  }
}
