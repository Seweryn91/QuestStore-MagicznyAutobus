package com.codecool.queststore.model.shop.artifact;

import com.google.common.annotations.VisibleForTesting;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArtifactTest {


    @Test
    void TestIfArtifactAcceptsNegativeCost() {
        boolean errorFound = false;
        Artifact artifact = new Artifact(0, 0, "name", "description", -100, "imageName", "imageMarkedName", false);
        if(artifact.getCOST() < 0){
            errorFound = true;
        }
        Assert.assertFalse(errorFound);
    }

    @Test
    void TestIfArtifactAcceptsEmptyName(){
        boolean errorFound = true;
        Artifact artifact = new Artifact(0, 0, "", "description", 0, "imageName", "imageMarkedName", false);
        if(!artifact.getNAME().equals("")){
            errorFound = false;
        }
        Assert.assertFalse(errorFound);
    }

    @Test
    void TestIfArtifactAcceptsEmptyDescription(){
        boolean errorFound = true;
        Artifact artifact = new Artifact(0, 0, "name", "", 0, "imageName", "imageMarkedName", false);
        if(!artifact.getDESCRIPTION().equals("")){
            errorFound = false;
        }
        Assert.assertFalse(errorFound);
    }

    @Test
    void TestIfArtifactAcceptsEmptyImageName(){
        boolean errorFound = true;
        Artifact artifact = new Artifact(0, 0, "name", "description", 0, "", "imageMarkedName", false);
        if(!artifact.getIMAGE_FILENAME().equals("")){
            errorFound = false;
        }
        Assert.assertFalse(errorFound);
    }

    @Test
    void TestIfArtifactAcceptsEmptyImageMarkedName(){
        boolean errorFound = true;
        Artifact artifact = new Artifact(0, 0, "name", "description", 0, "imageName", "", false);
        if(!artifact.getIMAGE_MARKED_FILENAME().equals("")){
            errorFound = false;
        }
        Assert.assertFalse(errorFound);
    }

}