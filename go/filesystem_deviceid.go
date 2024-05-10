// You can edit this code!
// Click here and start typing.

package main

import (
	"fmt"
	"os"
	"syscall"
)

type StateOS struct {
	Inode  uint64 `json:"inode," struct:"inode"`
	Device uint64 `json:"device," struct:"device"`
}

func main() {
	info, err := os.Stat("/")
	if err != nil {
		// handle error
	}

	stat := info.Sys().(*syscall.Stat_t)

	// Convert inode and dev to uint64 to be cross platform compatible
	fileState := StateOS{
		Inode:  uint64(stat.Ino),
		Device: uint64(stat.Dev),
	}

	fmt.Println(fileState.Device)
}
