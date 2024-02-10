/*
 * Copyright (c) 2019 OpenFTC Team
 * Derived work copyright (c) 2024 The Knights of Ni
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.knightsofni.acv;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.OpModeManagerImpl;
import com.qualcomm.robotcore.robocol.Command;

import com.qualcomm.robotcore.util.RobotLog;
import org.firstinspires.ftc.robotcore.internal.network.NetworkConnectionHandler;
import org.firstinspires.ftc.robotcore.internal.network.RobotCoreCommandList;
import org.firstinspires.ftc.robotcore.internal.system.AppUtil;

public abstract class RustFTCCameraBase {

    public RustFTCCameraBase() {
    }

    protected void emulateEStop(Exception e) {
        RobotLog.ee("Android CV", e, "User code threw an uncaught exception");

        OpModeManagerImpl mgr = OpModeManagerImpl.getOpModeManagerOfActivity(AppUtil.getInstance().getActivity());
        mgr.initOpMode(OpModeManagerImpl.DEFAULT_OP_MODE_NAME);

        // Get the trace as a string
        String stacktrace = Log.getStackTraceString(e);
        String[] lines = stacktrace.split("\n");
        StringBuilder builder = new StringBuilder();

        // Truncate at 15 lines
        for (int i = 0; i < Math.min(lines.length, 15); i++) {
            builder.append(lines[i]).append("\n");
        }

        // Send it off to the DS
        NetworkConnectionHandler.getInstance().sendCommand(new Command(RobotCoreCommandList.CMD_SHOW_STACKTRACE, builder.toString()));
    }

}