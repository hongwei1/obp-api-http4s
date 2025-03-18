package http4s

import cats.effect._
import org.http4s.{HttpRoutes, _}
import org.http4s.dsl.io._
import cats.implicits._
//import code.api.util.{APIUtil, CustomJsonFormats}
//import code.bankconnectors.Connector
//import code.model.dataAccess.MappedBank
//import com.openbankproject.commons.model.BankCommons
//import net.liftweb.json.{DefaultFormats, Extraction, Formats, MappingException, compactRender, parse}
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl

import scala.language.higherKinds
import cats.effect._
//import code.api.v4_0_0.JSONFactory400
import org.http4s._
import org.http4s.dsl.io._
//import net.liftweb.json.JsonAST.{JValue, prettyRender}
import org.slf4j.LoggerFactory

object RestRoutes {


  private val logger = LoggerFactory.getLogger(classOf[Nothing])
  
//  implicit val formats: Formats = CustomJsonFormats.formats
//  implicit val formats: Formats = DefaultFormats
  
//  val a31 = code.api.Constant.directLoginHeaderName
//  val a = com.openbankproject.commons.model.BankId("1")
  
  
  
  val helloWorldService: HttpRoutes[IO] = HttpRoutes.of[IO] {
    case GET -> Root / "hello" / name =>
      logger.info(s"Hello, $name.")
//      val banks = Connector.connector.vend.getBanksLegacy(None).map(_._1).openOrThrowException("xxxxx")
      Ok(s"Hello, $name. $name")
  }


//  val bankServices: HttpRoutes[IO] = HttpRoutes.of[IO] {
//    case GET -> Root / "banks"  =>
//      val banks = Connector.connector.vend.getBanksLegacy(None).map(_._1).openOrThrowException("xxxxx")
//      Ok(prettyRender(Extraction.decompose(banks)))
//    case GET -> Root / "banks"/ "future"  =>
//
//      Ok(IO.fromFuture(IO(
//        for {
//          (banks, callContext) <- code.api.util.NewStyle.function.getBanks(None)
//        } yield {
//          prettyRender(Extraction.decompose(JSONFactory400.createBanksJson(banks)))
//        }
//      )))
//
//      val banks = Connector.connector.vend.getBanksLegacy(None).map(_._1).openOrThrowException("xxxxx")
//      Ok(prettyRender(Extraction.decompose(banks)))
//    case GET -> Root / "banks" / IntVar(bankId) =>
//      val bank = BankCommons(
//        bankId = com.openbankproject.commons.model.BankId("bankIdExample.value"),
//        shortName = "bankShortNameExample.value",
//        fullName = "bankFullNameExample.value",
//        logoUrl = "bankLogoUrlExample.value",
//        websiteUrl = "bankWebsiteUrlExample.value",
//        bankRoutingScheme = "bankRoutingSchemeExample.value",
//        bankRoutingAddress = "bankRoutingAddressExample.value",
//        swiftBic = "bankSwiftBicExample.value",
//        nationalIdentifier = "bankNationalIdentifierExample.value")
//      Ok(prettyRender(Extraction.decompose(bank)))
//  }
  
}