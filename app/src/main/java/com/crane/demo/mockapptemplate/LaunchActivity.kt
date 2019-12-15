package com.crane.demo.mockapptemplate

import com.crane.mockapp.core.MockApp
import com.crane.mockapp.core.MockAppActivity
import com.crane.mockapp.core.model.layouts.LayoutDescriptor
import com.crane.mockapp.core.model.layouts.ProjectSource

class LaunchActivity : MockAppActivity() {

    override fun resolveLayoutDescriptor(): LayoutDescriptor? {

        val projects = ProjectSource.getInstance().projectModels
        if (projects.isEmpty())
            return null
        val project = projects[0]

        val mainLayoutId = project.mainLayoutId
        val layout = mainLayoutId?.let {
            ProjectSource.getInstance().getLayoutModel(project.id, mainLayoutId)
        } ?: ProjectSource.getInstance().getLayoutModels(project.id).getOrNull(0)

        layout ?: return null

        return MockApp.loadLayoutDescriptor(this, project.id, layout.id)
    }
}