package net.degols.example.fsgate

import net.degols.libs.election.{ConfigurationService, ElectionService, ElectionWrapper}
import org.slf4j.LoggerFactory
import javax.inject.{Inject, Singleton}
import net.degols.example.fsgate.example.pipeline._
import net.degols.libs.cluster.{ClusterConfiguration, Tools}
import net.degols.libs.cluster.core.Cluster
import net.degols.libs.filesgate.core.EngineLeader
import net.degols.libs.filesgate.core.engine.Engine
import net.degols.libs.filesgate.pipeline.PipelineStepService
import net.degols.libs.filesgate.utils.{FilesgateConfiguration, Tools}
import play.libs.akka.InjectedActorSupport

import scala.concurrent.ExecutionContext

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
class EngineExample @Inject()(implicit tools: Tools, engine: Engine, electionService: ElectionService, configurationService: ConfigurationService, clusterConfiguration: ClusterConfiguration, filesgateConfiguration: FilesgateConfiguration, cluster: Cluster)
  extends EngineLeader(engine, tools, electionService, configurationService, clusterConfiguration, filesgateConfiguration, cluster) with InjectedActorSupport{

  private val logger = LoggerFactory.getLogger(getClass)
  override def receive: Receive = {
    case message =>
      logger.debug(s"[LeaderExample] Received unknown message: $message")
  }

  /**
    * Must be implemented by the developer, for the pipeline step
    */
  override def startStepService(workerTypeId: String): PipelineStepService = {
    workerTypeId match {
      case "example.source" => new Source()
      case "example.matcher" => new Matcher()
      case "example.preDownload" => new PreDownload()
      case "example.download" => new Download(tools)
      case "example.preStorage" => new PreStorage()
      case "example.storage" => new Storage()
      case "example.preMetadata" => new PreMetadata()
      case "example.metadata" => new Metadata()
      case "example.postMetadata" => new PostMetadata()
      case x => throw new Exception(s"WorkerTypeId received is not implemented: $workerTypeId")
    }
  }
}
