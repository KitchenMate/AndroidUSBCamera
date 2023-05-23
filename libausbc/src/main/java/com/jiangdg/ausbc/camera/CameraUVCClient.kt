/*
 * Copyright 2017-2023 Jiangdg
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jiangdg.ausbc.camera

import android.content.ContentValues
import android.content.Context
import android.graphics.SurfaceTexture
import android.hardware.usb.UsbDevice
import android.os.Build
import android.provider.MediaStore
import android.view.Surface
import android.view.SurfaceView
import android.view.TextureView
import androidx.annotation.RequiresApi
import com.jiangdg.ausbc.MultiCameraClient
import com.jiangdg.ausbc.MultiCameraClient.Companion.CAPTURE_TIMES_OUT_SEC
import com.jiangdg.ausbc.MultiCameraClient.Companion.MAX_NV21_DATA
import com.jiangdg.ausbc.callback.ICameraStateCallBack
import com.jiangdg.ausbc.callback.ICaptureCallBack
import com.jiangdg.ausbc.callback.IPreviewDataCallBack
import com.jiangdg.ausbc.camera.bean.CameraRequest
import com.jiangdg.ausbc.camera.bean.PreviewSize
import com.jiangdg.ausbc.utils.CameraUtils
import com.jiangdg.ausbc.utils.Logger
import com.jiangdg.ausbc.utils.MediaUtils
import com.jiangdg.ausbc.utils.Utils
import com.jiangdg.ausbc.widget.IAspectRatio
import com.jiangdg.usb.USBMonitor
import com.jiangdg.uvc.IFrameCallback
import com.jiangdg.uvc.UVCCamera
import java.io.File
import java.io.FileDescriptor
import java.util.concurrent.TimeUnit

/** UVC Camera
 *
 * @author Created by jiangdg on 2023/1/15
 */

open class CameraUVCClient(ctx: Context, device: UsbDevice) : CameraUVC(ctx, device) {

    open fun callCaptureVideoStop() {
        return this.captureVideoStop();
    }

    open fun callCaptureVideoStart(callback: ICaptureCallBack, fd: FileDescriptor, duration: Long) {
        return this.captureVideoStart(callback, fd, duration);
    }

    @RequiresApi(Build.VERSION_CODES.O)
    open fun callIsRecording(): Boolean {
        return this.isRecording();
    }

    open fun callGetSuitableSize(maxWidth: Int, maxHeight: Int): PreviewSize {
        return this.getSuitableSize(maxWidth, maxHeight);
    }

    open fun callCloseCamera() {
        return this.closeCamera();
    }

    open fun callGetUsbDevice(): UsbDevice {
        return this.getUsbDevice();
    }

    open fun callOpenCamera(surfaceTexture: SurfaceTexture, cameraRequest: CameraRequest) {
        return this.openCamera(surfaceTexture, cameraRequest);
    }

    open fun callAddPreviewDataCallback(previewCallBack: IPreviewDataCallBack) {
        return this.addPreviewDataCallBack(previewCallBack);
    }

    open fun callSetUsbControlBlock(ctrlBlock : USBMonitor.UsbControlBlock) {
        return this.setUsbControlBlock(ctrlBlock);
    }

    open fun callIsCameraOpened() : Boolean {
        return this.isCameraOpened();
    }
}