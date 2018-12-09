package net.degols.example.fsgate

import java.io.File

import akka.actor.{ActorRef, Props}
import net.degols.filesgate.libs.election.{ConfigurationService, ElectionService, ElectionWrapper}
import org.slf4j.LoggerFactory
import javax.inject.{Inject, Singleton}
import net.degols.example.fsgate.example.Activity
import net.degols.filesgate.libs.cluster.{ClusterConfiguration, Tools}
import net.degols.filesgate.libs.cluster.core.Cluster
import net.degols.filesgate.libs.cluster.manager.{Manager, WorkerLeader}
import net.degols.filesgate.libs.cluster.messages.{BasicLoadBalancerType, ClusterInstance, JVMInstance, WorkerTypeInfo}
import net.degols.filesgate.libs.filesgate.core.EngineLeader
import net.degols.filesgate.libs.filesgate.core.engine.Engine
import net.degols.filesgate.libs.filesgate.pipeline.PipelineStepService
import net.degols.filesgate.libs.filesgate.utils.FilesgateConfiguration
import play.libs.akka.InjectedActorSupport

import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Try

/**
  * The developer does not need to start custom actors, but he does need to instantiate the various classes in this class.
  * The configuration (application.conf) is used to start the related actor for every step.
  * There are two reasons
  * @param engine
  * @param electionService
  * @param configurationService
  * @param clusterConfiguration
  * @param filesgateConfiguration
  * @param cluster
  */
@Singleton
class EngineExample @Inject()(engine: Engine, electionService: ElectionService, configurationService: ConfigurationService, clusterConfiguration: ClusterConfiguration, filesgateConfiguration: FilesgateConfiguration, cluster: Cluster)
  extends EngineLeader(engine, electionService, configurationService, clusterConfiguration, filesgateConfiguration, cluster) with InjectedActorSupport{

  private val logger = LoggerFactory.getLogger(getClass)
  override def receive: Receive = {
    case message =>
      logger.debug(s"[LeaderExample] Received unknown message: $message")
  }

  /**
    * Must be implemented by the developer, for the pipeline step
    */
  override def startStepService(workerTypeId: String): PipelineStepService = ??? // TODO: Implement
}
