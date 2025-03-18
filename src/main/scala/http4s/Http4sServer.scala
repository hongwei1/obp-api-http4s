package http4s

import cats.data.{Kleisli, OptionT}
import cats.effect._
import com.comcast.ip4s._
import org.http4s._
import org.http4s.ember.server._
import org.http4s.implicits._

import scala.language.higherKinds
object Http4sServer extends IOApp {

  
  //  val services: Kleisli[({type λ[β$0$] = OptionT[IO, β$0$]})#λ, Request[IO], Response[IO]] = bankServices <+> helloWorldService
  val services: Kleisli[({type λ[β$0$] = OptionT[IO, β$0$]})#λ, Request[IO], Response[IO]] =  RestRoutes.helloWorldService
  val httpApp: Kleisli[IO, Request[IO], Response[IO]] = (services).orNotFound

//  //Start OBP relvent objects, and settings
//  new bootstrap.liftweb.Boot().boot
  
  override def run(args: List[String]): IO[ExitCode] = EmberServerBuilder
    .default[IO]
    .withHost(ipv4"0.0.0.0")
    .withPort(port"8081")
    .withHttpApp(httpApp)
    .build
    .use(_ => IO.never)
    .as(ExitCode.Success)
}

//this is testing code
object myApp extends App{
  import cats.effect.unsafe.implicits.global
  Http4sServer.run(Nil).unsafeRunSync()
//  Http4sServer.run(Nil).unsafeToFuture()//.unsafeRunSync()
}

