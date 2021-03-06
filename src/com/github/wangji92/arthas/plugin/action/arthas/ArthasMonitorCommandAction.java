package com.github.wangji92.arthas.plugin.action.arthas;

import com.github.wangji92.arthas.plugin.constants.ArthasCommandConstants;
import com.github.wangji92.arthas.plugin.utils.ClipboardUtils;
import com.github.wangji92.arthas.plugin.utils.NotifyUtils;
import com.intellij.openapi.project.Project;

/**
 * Monitor method execution statistics, e.g. total/success/failure count, average rt, fail rate, etc.
 * @author 汪小哥
 * @date 09-01-2020
 */
public class ArthasMonitorCommandAction extends BaseArthasPluginAction {

    @Override
    public void doCommand(String className, String methodName, Project project) {

        String command = String.join(" ", "monitor", className, methodName, "-n", ArthasCommandConstants.INVOKE_MONITOR_COUNT, "--cycle", ArthasCommandConstants.INVOKE_MONITOR_INTERVAL);
        ClipboardUtils.setClipboardString(command);
        NotifyUtils.notifyMessage(project,"方法执行监控,非实时 -c 统计周期（10秒）-n 执行次数统计(10次) 可以手动修改大一点，详情参看 help monitor");
    }
}
