import javax.servlet.ServletContext

import ch.baloise.gitbucket.apiextension.ApiExtensionController
import ch.baloise.gitbucket.secext.replist.RepolistController
import gitbucket.core.controller.Context
import gitbucket.core.plugin.{Link, PluginRegistry}
import gitbucket.core.service.RepositoryService.RepositoryInfo
import gitbucket.core.service.SystemSettingsService.SystemSettings
import io.github.gitbucket.solidbase.model.Version


class Plugin extends gitbucket.core.plugin.Plugin {
  override val pluginId: String = "repolistextension"
  override val pluginName: String = "Repository List Extension"
  override val versions: Seq[Version] = List(new Version("1.0.0"))
  override val description: String = "List public repositories in ui and api"

  override def initialize(registry: PluginRegistry, context: ServletContext, settings: SystemSettings): Unit = {
    super.initialize(registry, context, settings)

  }

  override val controllers = Seq(
    "/*" -> new RepolistController,
    "/*" -> new ApiExtensionController
  )

  override val globalMenus = Seq(
    (context: Context) => Some(Link("repolist", "Repository List", "repolist"))
  )

  override val dashboardTabs = Seq(
    (context: Context) => Some(Link("repolist", "Repository List", "repolist"))
  )


}
