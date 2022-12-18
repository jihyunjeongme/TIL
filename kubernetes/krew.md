# Krew 
- itself is a kubectl plugin that is installed and updated via Krew (yes, Krew self-hosts).

## Installing
- (Official Link)[https://krew.sigs.k8s.io/docs/user-guide/setup/install/]

### macOS/Linux
#### Bash or ZSH shells
1. Make sure that `git` is installed.

2. Run this command to download and install `krew`:
```bash
(
  set -x; cd "$(mktemp -d)" &&
  OS="$(uname | tr '[:upper:]' '[:lower:]')" &&
  ARCH="$(uname -m | sed -e 's/x86_64/amd64/' -e 's/\(arm\)\(64\)\?.*/\1\2/' -e 's/aarch64$/arm64/')" &&
  KREW="krew-${OS}_${ARCH}" &&
  curl -fsSLO "https://github.com/kubernetes-sigs/krew/releases/latest/download/${KREW}.tar.gz" &&
  tar zxvf "${KREW}.tar.gz" &&
  ./"${KREW}" install krew
)
```

3. Add the `$HOME/.krew/bin` directory to your PATH environment variable. To do this, update your `.bashrc` or `.zshrc` file and append the following line:

```bash
export PATH="${KREW_ROOT:-$HOME/.krew}/bin:$PATH"
```

and restart your shell.

4. Run `kubectl krew` to check the installation.

