package com.example.myapplication.dagger

import com.example.myapplication.viewmodel.MainAvtivityViewModel
import dagger.Component

@Component(modules = [RepositaryModule::class])
interface ApplicationComponent {


fun inject(mainAvtivityViewModel: MainAvtivityViewModel)

}