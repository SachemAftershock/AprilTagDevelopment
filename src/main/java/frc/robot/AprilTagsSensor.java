package frc.robot;

import java.util.List;
import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonTrackedTarget;

public class AprilTagsSensor {
    
    PhotonCamera camera = new PhotonCamera("Microsoft_LifeCam_HD-3000");
    int count = 0;
    int outputNum = 0;

    public void aprilTagsSensor_Periodic() {
        
        if (count++ % 50 == 0) {
            var result = camera.getLatestResult();
            if (result.hasTargets()) {
                System.out.println(outputNum++ + " : "); 
                List<PhotonTrackedTarget> targets = result.getTargets();
                for (PhotonTrackedTarget e: targets) {
                    System.out.printf(
                        "  ID %d, Pitch %3.1f, Yaw %3.1f, Skew %3.1f, Area %3.1f, PoseAmbiguity %3.1f, Best X %3.1f Y %3.1f Z %3.1f, Alt X %3.1f Y %3.1f Z %3.1f",
                        e.getFiducialId(),
                        e.getPitch(),
                        e.getYaw(),
                        e.getSkew(),
                        e.getArea(),
                        e.getPoseAmbiguity(),
                        e.getBestCameraToTarget().getX(),
                        e.getBestCameraToTarget().getY(),
                        e.getBestCameraToTarget().getZ(),
                        e.getAlternateCameraToTarget().getX(),
                        e.getAlternateCameraToTarget().getY(),
                        e.getAlternateCameraToTarget().getZ()
                    );
                    System.out.println("");    
                }
            }
        }
    }
}
