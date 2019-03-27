package com.crane.demo.mockapptemplate

import com.crane.mockapp.core.MockApp
import com.crane.mockapp.core.MockAppActivity
import com.crane.mockapp.core.model.layouts.LayoutDescriptor
import com.crane.mockapp.core.model.layouts.ProjectService
import com.crane.mockapp.core.model.layouts.ProjectServiceFactory

class LaunchActivity : MockAppActivity() {

    override fun resolveLayoutDescriptor(): LayoutDescriptor? {

        val projects = ProjectServiceFactory.getInstance(this).findInternalProjectModels()
        if (projects.isEmpty())
            return null
        val project = projects.get(0)

        val mainLayoutId = ProjectServiceFactory.getInstance(this).getMainLayoutId(project.id)
        var layout = ProjectServiceFactory.getInstance(this).findLayoutModel(project.id, mainLayoutId)
        if (layout == null) {
            val layouts =
                ProjectServiceFactory.getInstance(this).findLayoutModels(ProjectService.LAYOUT_FILTER_ALL, project.id)
            if (layouts.isEmpty())
                return null
            layout = layouts.get(0)
        }

        return MockApp.loadLayoutDescriptor(this, project.id, layout.id)
    }
}