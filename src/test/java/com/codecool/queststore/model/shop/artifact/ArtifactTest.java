package com.codecool.queststore.model.shop.artifact;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArtifactTest {


    @Test
    public void TestIfArtifactAcceptsNegativeCost() {
        assertThrows(IllegalArgumentException.class, () -> new Artifact(0,0,"name", "description", 0,"imageMarkedName", "imageMarkedName", null, false));
    }

    @Test
    void TestIfArtifactAcceptsEmptyName(){
        assertThrows(IllegalArgumentException.class, () -> new Artifact(0, 0, "", "description", 0, "imageName", "imageMarkedName", null, false));
    }

    @Test
    void TestIfArtifactAcceptsNullName(){
        assertThrows(IllegalArgumentException.class, () -> new Artifact(0, 0, null, "description", 0, "imageName", "imageMarkedName", null, false));
    }

    @Test
    void TestIfArtifactAcceptsEmptyDescription(){
        assertThrows(IllegalArgumentException.class, () -> new Artifact(0,0, "name", "description",0,"imageName","imageName",null, false));
    }

    @Test
    void TestIfArtifactAcceptsNullDescription(){
        assertThrows(IllegalArgumentException.class, () -> new Artifact(0, 0, "name", null, 0, "imageName", "imageMarkedName", null, false));
    }


    @Test
    void TestIfArtifactAcceptsEmptyImageName(){
        assertThrows(IllegalArgumentException.class, () -> new Artifact(0,0,"name","description",0,"","imageMarkedName", null,false));
    }

    @Test
    void TestIfArtifactAcceptsNullImageName(){
        assertThrows(IllegalArgumentException.class, () -> new Artifact(0,0,"name","description",0,null,"imageMarkedName", null,false));
    }

    @Test
    void TestIfArtifactAcceptsEmptyImageMarkedName(){
        assertThrows(IllegalArgumentException.class, () -> new Artifact(0,0,"name","description",0,"imageName","", null, false));
    }

    @Test
    void TestIfArtifactAcceptsNullImageMarkedName(){
        assertThrows(IllegalArgumentException.class, () -> new Artifact(0,0,"name","description",0,"imageName",null, null, false));
    }

}