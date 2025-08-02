package com.deepakjetpackcompose.artestapp.util

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.Color
import com.google.android.filament.Engine
import com.google.ar.core.Anchor
import io.github.sceneview.ar.node.AnchorNode
import io.github.sceneview.loaders.MaterialLoader
import io.github.sceneview.loaders.ModelLoader
import io.github.sceneview.model.ModelInstance
import io.github.sceneview.node.CubeNode
import io.github.sceneview.node.ModelNode

object UtilClass {
    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    fun createAnchorNode(
        engine: Engine,
        modelLoader: ModelLoader,
        modelInstance: MutableList<ModelInstance>,
        anchor: Anchor,
        model:String,
        materialLoader: MaterialLoader
    ): AnchorNode {
        val anchorNode= AnchorNode(engine = engine, anchor = anchor)
        val modelNode= ModelNode(
            modelInstance=modelInstance.apply {
                if(isEmpty()){
                    this+=modelLoader.createInstancedModel(model,10)
                }
            }.removeLast(),
            scaleToUnits = 0.2f
        ).apply {
            isEditable=true
        }

        val boundingBox= CubeNode(
            engine = engine,
            size = modelNode.extents,
            center = modelNode.center,
            materialInstance = materialLoader.createColorInstance(Color.White)
        ).apply {
            isVisible=true
        }

        modelNode.addChildNode(boundingBox)
        anchorNode.addChildNode(modelNode)

        listOf(modelNode,anchorNode).forEach {
            it.onEditingChanged={editingTransform->
                boundingBox.isVisible=editingTransform.isNotEmpty()

            }
        }

        return anchorNode
    }


    val alphabets = mapOf(
        "A" to "models/apple.glb",
        "B" to "models/ball.glb",
        "C" to "models/cobra_car.glb",
        "D" to "models/dog.glb",
        "E" to "models/elephant.glb",
        "F" to "models/fox.glb",
        "G" to "models/goat.glb",
        "H" to "models/hen.glb",
        "I" to "models/icecream.glb",
        "J" to "models/jug.glb",
        "K" to "models/kite.glb",
        "L" to "models/lion.glb",
        "M" to "models/monkey.glb",
        "N" to "models/nest.glb",
        "O" to "models/owl.glb",
        "P" to "models/porche.glb",
        "Q" to "models/quail.glb",
        "R" to "models/rat.glb",
        "S" to "models/ship.glb",
        "T" to "models/telephone.glb",
        "U" to "models/umbrella.glb",
        "V" to "models/van.glb",
        "W" to "models/watch.glb",
        "X" to "models/xylophone.glb",
        "Y" to "models/yacht.glb",
        "Z" to "models/zebra.glb"
    )

    fun getModelForAlphabet(alphabet: String): String{
        val modelName=alphabets[alphabet]?:error("model not found")
        return modelName
    }

}