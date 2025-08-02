package com.deepakjetpackcompose.artestapp.ui.screens

import android.os.Build
import android.util.Log
import android.view.MotionEvent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.deepakjetpackcompose.artestapp.util.UtilClass
import com.google.ar.core.Config
import com.google.ar.core.Frame
import com.google.ar.core.TrackingFailureReason
import io.github.sceneview.Scene
import io.github.sceneview.ar.ARScene
import io.github.sceneview.ar.arcore.createAnchorOrNull
import io.github.sceneview.ar.arcore.isValid
import io.github.sceneview.ar.rememberARCameraNode
import io.github.sceneview.model.ModelInstance
import io.github.sceneview.node.Node
import io.github.sceneview.rememberCameraNode
import io.github.sceneview.rememberCollisionSystem
import io.github.sceneview.rememberEngine
import io.github.sceneview.rememberMaterialLoader
import io.github.sceneview.rememberModelLoader
import io.github.sceneview.rememberNodes
import io.github.sceneview.rememberOnGestureListener
import io.github.sceneview.rememberRenderer
import io.github.sceneview.rememberView


@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@Composable
fun ArScreen(navController: NavController,model:String,modifier: Modifier = Modifier) {
    val engine= rememberEngine()
    val modelLoader= rememberModelLoader(engine = engine)
    val materialLoader= rememberMaterialLoader(engine = engine)
    val cameraNode= rememberARCameraNode(engine = engine)
    val childNode= rememberNodes()
    val view= rememberView(engine = engine)
    val collisionSystem= rememberCollisionSystem(view = view)
    val planeRender= remember{
        mutableStateOf(true)
    }

    val modelInstance=remember {
        mutableListOf<ModelInstance>()
    }

    val trackingFailureReason=remember {
        mutableStateOf<TrackingFailureReason?>(null)
    }

    val frames=remember {
        mutableStateOf<Frame?>(null)
    }




    ARScene(
        modifier = modifier.fillMaxSize(),
        collisionSystem = collisionSystem,
        engine = engine,
        view = view,
        modelLoader = modelLoader,
        childNodes = childNode,
        cameraNode = cameraNode,
        materialLoader = materialLoader,
        planeRenderer = planeRender.value,
        onTrackingFailureChanged = {
            trackingFailureReason.value=it
        },
        onSessionUpdated = {session,updatedFrame->
            frames.value=updatedFrame
        },
        sessionConfiguration = {session,config->
            config.depthMode=when(session.isDepthModeSupported(Config.DepthMode.AUTOMATIC)){
                true->Config.DepthMode.AUTOMATIC
                else->Config.DepthMode.DISABLED
            }
            config.lightEstimationMode=Config.LightEstimationMode.ENVIRONMENTAL_HDR
        },
        onGestureListener = rememberOnGestureListener(
            onSingleTapConfirmed = {e: MotionEvent,node: Node?->
                if(node==null){
                    val hitTestResult=frames.value?.hitTest(e.x,e.y)
                    hitTestResult?.firstOrNull{
                        it.isValid(depthPoint = false, point = false)
                    }?.createAnchorOrNull()?.let {
                        val nodeModel= UtilClass.createAnchorNode(
                            engine = engine,
                            modelLoader = modelLoader,
                            modelInstance = modelInstance,
                            anchor = it,
                            model = UtilClass.getModelForAlphabet(model),
                            materialLoader = materialLoader)

                        childNode+=nodeModel
                    }
                }

            }
        )

    )








}