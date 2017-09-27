package articles.controllers.mappings

import articles.models.{ArticleWrapper, _}
import config.DateTimeJsonMappings
import play.api.libs.json._
import users.controllers.mappings.UserJsonMappings

trait ArticleJsonMappings extends UserJsonMappings with DateTimeJsonMappings {
  implicit val articleIdReads: Reads[ArticleId] = Reads((Reads.LongReads.reads(_)).andThen(_.map(ArticleId)))
  implicit val articleIdWrites: Writes[ArticleId] = Writes((Writes.LongWrites.writes(_)).compose(_.value))

  implicit val newArticleFormat: Format[NewArticle] = Json.format[NewArticle]
  implicit val newArticleWrapperFormat: Format[NewArticleWrapper] = Json.format[NewArticleWrapper]
  implicit val articleFormat: Format[Article] = Json.format[Article]

  implicit val articlePageFormat: Format[ArticlePage] = Json.format[ArticlePage]
  implicit val articleWrapperFormat: Format[ArticleWrapper] = Json.format[ArticleWrapper]
}
