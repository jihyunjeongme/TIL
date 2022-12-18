# kube-neat
- Kubernetes manifests to make them more readable.

## Prerequisite
- The `krew` is installed.


### System environment
- Kubernetes veson: `Client Version: version.Info{Major:"1", Minor:"20", GitVersion:"v1.20.1", GitCommit:"c4d752765b3bbac2237bf87cf0b1c2e307844666", GitTreeState:"clean", BuildDate:"2020-12-18T12:09:25Z", GoVersion:"go1.15.5", Compiler:"gc", Platform:"linux/amd64"}`
- OS: `NAME="CentOS Linux", VERSION="7 (Core)"`


## The steps for Demo
1. `alias k=kubectl`
2. `k krew install neat`
```bash
[node1 ~]$ k krew install neat
Updated the local copy of plugin index.
Installing plugin: neat
Installed plugin: neat
\
 | Use this plugin:
 |      kubectl neat
 | Documentation:
 |      https://github.com/itaysk/kubectl-neat
/
WARNING: You installed plugin "neat" from the krew-index plugin repository.
   These plugins are not audited for security by the Krew maintainers.
   Run them at your own risk.
```
3. `kubectl run busybox --image=busybox`
    - `busybox` image have 1~5MB size and useful utilities such as `ping`, `nc`, `nslookup` so it is widely used for debugging.

```bash
[node1 ~]$ k get pod
NAME      READY   STATUS      RESTARTS   AGE
busybox   0/1     Completed   1          10s
```


4. `k get pod busybox -o yaml`
  
```yaml
apiVersion: v1
kind: Pod
metadata:
  creationTimestamp: "2022-12-18T02:31:34Z"
  labels:
    run: busybox
  managedFields:
  - apiVersion: v1
    fieldsType: FieldsV1
    fieldsV1:
      f:metadata:
        f:labels:
          .: {}
          f:run: {}
      f:spec:
        f:containers:
          k:{"name":"busybox"}:
            .: {}
            f:image: {}
            f:imagePullPolicy: {}
            f:name: {}
            f:resources: {}
            f:terminationMessagePath: {}
            f:terminationMessagePolicy: {}
        f:dnsPolicy: {}
        f:enableServiceLinks: {}
        f:restartPolicy: {}
        f:schedulerName: {}
        f:securityContext: {}
        f:terminationGracePeriodSeconds: {}
    manager: kubectl-run
    operation: Update
    time: "2022-12-18T02:31:34Z"
  - apiVersion: v1
    fieldsType: FieldsV1
    fieldsV1:
      f:status:
        f:conditions:
          k:{"type":"ContainersReady"}:
            .: {}
            f:lastProbeTime: {}
            f:lastTransitionTime: {}
            f:message: {}
            f:reason: {}
            f:status: {}
            f:type: {}
          k:{"type":"Initialized"}:
            .: {}
            f:lastProbeTime: {}
            f:lastTransitionTime: {}
            f:status: {}
            f:type: {}
          k:{"type":"Ready"}:
            .: {}
            f:lastProbeTime: {}
            f:lastTransitionTime: {}
            f:message: {}
            f:reason: {}
            f:status: {}
            f:type: {}
        f:containerStatuses: {}
        f:hostIP: {}
        f:phase: {}
        f:podIP: {}
        f:podIPs:
          .: {}
          k:{"ip":"10.5.1.2"}:
            .: {}
            f:ip: {}
        f:startTime: {}
    manager: kubelet
    operation: Update
    time: "2022-12-18T02:31:41Z"
  name: busybox
  namespace: default
  resourceVersion: "671"
  uid: a24b1016-fc53-4d16-973b-610b12e4dce3
spec:
  containers:
  - image: busybox
    imagePullPolicy: Always
    name: busybox
    resources: {}
    terminationMessagePath: /dev/termination-log
    terminationMessagePolicy: File
    volumeMounts:
    - mountPath: /var/run/secrets/kubernetes.io/serviceaccount
      name: default-token-btk9w
      readOnly: true
  dnsPolicy: ClusterFirst
  enableServiceLinks: true
  nodeName: node2
  preemptionPolicy: PreemptLowerPriority
  priority: 0
  restartPolicy: Always
  schedulerName: default-scheduler
  securityContext: {}
  serviceAccount: default
  serviceAccountName: default
  terminationGracePeriodSeconds: 30
  tolerations:
  - effect: NoExecute
    key: node.kubernetes.io/not-ready
    operator: Exists
    tolerationSeconds: 300
  - effect: NoExecute
    key: node.kubernetes.io/unreachable
    operator: Exists
    tolerationSeconds: 300
  volumes:
  - name: default-token-btk9w
    secret:
      defaultMode: 420
      secretName: default-token-btk9w
status:
  conditions:
  - lastProbeTime: null
    lastTransitionTime: "2022-12-18T02:31:34Z"
    status: "True"
    type: Initialized
  - lastProbeTime: null
    lastTransitionTime: "2022-12-18T02:31:34Z"
    message: 'containers with unready status: [busybox]'
    reason: ContainersNotReady
    status: "False"
    type: Ready
  - lastProbeTime: null
    lastTransitionTime: "2022-12-18T02:31:34Z"
    message: 'containers with unready status: [busybox]'
    reason: ContainersNotReady
    status: "False"
    type: ContainersReady
  - lastProbeTime: null
    lastTransitionTime: "2022-12-18T02:31:34Z"
    status: "True"
    type: PodScheduled
  containerStatuses:
  - containerID: docker://bf5b897c576389758225ba0cde9e934d0ac7897e37db5ff044555d1b668092f0
    image: busybox:latest
    imageID: docker-pullable://busybox@sha256:3b3128d9df6bbbcc92e2358e596c9fbd722a437a62bafbc51607970e9e3b8869
    lastState:
      terminated:
        containerID: docker://4cf9c3c316d814dd06703f9c1eb3f86791d6fa99a70c4c33ae26e5f5498710f3
        exitCode: 0
        finishedAt: "2022-12-18T02:31:43Z"
        reason: Completed
        startedAt: "2022-12-18T02:31:43Z"
    name: busybox
    ready: false
    restartCount: 2
    started: false
    state:
      terminated:
        containerID: docker://bf5b897c576389758225ba0cde9e934d0ac7897e37db5ff044555d1b668092f0
        exitCode: 0
        finishedAt: "2022-12-18T02:31:59Z"
        reason: Completed
        startedAt: "2022-12-18T02:31:59Z"
  hostIP: 192.168.0.17
  phase: Running
  podIP: 10.5.1.2
  podIPs:
  - ip: 10.5.1.2
  qosClass: BestEffort
  startTime: "2022-12-18T02:31:34Z"
  ```

5. `k get pod busybox -o yaml|k neat`
   
```yaml
apiVersion: v1
kind: Pod
metadata:
  labels:
    run: busybox
  name: busybox
  namespace: default
spec:
  containers:
  - image: busybox
    name: busybox
  preemptionPolicy: PreemptLowerPriority
  priority: 0
  serviceAccountName: default
  tolerations:
  - effect: NoExecute
    key: node.kubernetes.io/not-ready
    operator: Exists
    tolerationSeconds: 300
  - effect: NoExecute
    key: node.kubernetes.io/unreachable
    operator: Exists
    tolerationSeconds: 300
```

## Summary
- `kubectl-neat` cleans up that redundant information for you.

### Reference
- https://github.com/itaysk/kubectl-neat
