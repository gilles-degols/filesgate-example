import com.google.inject.AbstractModule
import net.degols.example.fsgate.EngineExample
import play.api.libs.concurrent.AkkaGuiceSupport

class Module extends AbstractModule with AkkaGuiceSupport {

  override def configure(): Unit = {
    bind(classOf[LifeCycle]).asEagerSingleton()
    bindActor[EngineExample]("cluster-leader-example")
  }
}
