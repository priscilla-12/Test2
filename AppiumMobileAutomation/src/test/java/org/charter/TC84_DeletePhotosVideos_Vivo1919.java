package org.charter;

import org.charter.pageObjects.Android.galleryPage;
import org.charter.pageObjects.Android.videoAppPage;
import org.testng.annotations.Test;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TC84_DeletePhotosVideos_Vivo1919 extends BaseTest {

	@Test

	public void deletePhotosAndVideos() {
		try {

			// Delete video form Albus app
			galleryPage gallery = new galleryPage(driver);
			gallery.launchAppDirect("com.vivo.gallery", "com.android.gallery3d.vivo.GalleryTabActivity");
			gallery.deletePhoto();

			driver.pressKey(new KeyEvent(AndroidKey.HOME));
			Thread.sleep(3000);

			// Delete video from Videos App
			videoAppPage video = new videoAppPage(driver);
			video.launchAppDirect("com.android.VideoPlayer", "com.vivo.video.app.home.HomeActivity");
			video.deleteVideo();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
