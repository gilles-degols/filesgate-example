package net.degols.example.fsgate

import java.io.File

import akka.actor.{Actor, ActorRef, Kill, Props}
import net.degols.filesgate.libs.election.{ConfigurationService, ElectionService, ElectionWrapper}
import org.slf4j.LoggerFactory
import javax.inject.{Inject, Singleton}
import net.degols.example.fsgate.example.Activity
import net.degols.filesgate.libs.cluster.{ClusterConfiguration, Tools}
import net.degols.filesgate.libs.cluster.core.Cluster
import net.degols.filesgate.libs.cluster.manager.{Manager, WorkerLeader}
import net.degols.filesgate.libs.cluster.messages.{BasicLoadBalancerType, JVMInstance, WorkerTypeInfo}
import net.degols.filesgate.libs.filesgate.core.EngineLeader
import net.degols.filesgate.libs.filesgate.core.engine.Engine
import net.degols.filesgate.libs.filesgate.utils.FilesgateConfiguration
import play.api.libs.concurrent.InjectedActorSupport

import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Try

@Singleton
class EngineExample @Inject()(engine: Engine, electionService: ElectionService, configurationService: ConfigurationService, clusterConfiguration: ClusterConfiguration, filesgateConfiguration: FilesgateConfiguration, cluster: Cluster)
  extends EngineLeader(engine, electionService, configurationService, clusterConfiguration, filesgateConfiguration, cluster) with InjectedActorSupport{

  private val logger = LoggerFactory.getLogger(getClass)
  override def receive: Receive = {
    case message =>
      logger.debug(s"[LeaderExample] Received unknown message: $message")
  }

  /**
    * Class to implement by the developer.
    *
    * @param workerTypeId
    */
  override def startUserWorker(workerTypeId: String, actorName: String): ActorRef = {
    workerTypeId match {
      case "Activity" =>
        val worker = context.actorOf(Props.create(classOf[Activity]), name = actorName)
        worker ! "Super Stuff!"
        worker
      case _ => throw new Exception(s"Invalid WorkerTypeId received: $workerTypeId")
    }
  }

  /**
    * List of available WorkerActors given by the developer in the current jvm.
    */
  override def allUserWorkerTypeInfo: List[WorkerTypeInfo] = {
    List(
    )
  }
}
