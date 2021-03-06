# CCC-Platform
EIS developed BSP for the Miami and CCC board on top of a mainline Linux distribution. The Miami/CCC BSP is basically a lightweight OpenEmbedded based Linux Distribution.



# Initial setup

```
git clone https://github.com/Embedded-Development-EIS/CCC-Platform.git
cd CCC-Platform/
git submodule update --init
meta-ccc/scripts/init-oe.sh

cd build

# Edit local.conf to match your setup.
vi conf/local.conf

# To build your BSP it is necessary to set the correct MACHINE environment variable. 
# To do this change it in the "profile" script or just export the MACHINE environment 
# before building. Refer to meta-ccc/conf/machine for a list of values 
# (e.g. "miami-ccc").

# Edit fpga-image-wizard.bb to upload the desired bitstream and export location for hardware design.
vi ../meta-ccc/recipes-bsp/fpga/fpga-image-wizard.bb


# Then build your first image and relax a bit:
source profile
nice bitbake my-image
````

Note that "my-image" was designed to be used with DISTRO=tiny. It
expects to run with busybox-mdev instead of udev.

# Copying to SD-card

The simplest way to boot the resulting image is to copy it onto an SD card. In case you have not yet formatted and partitioned your SD-card yet, execute the following script first. This script partitions and formats an SD card so it can be used directly. This is only required once.

```
cd ~/CCC-Platform/build
sudo ../meta-ccc/scripts/partition_sd_card.sh
```

The meta-ccc/scripts/install-to-sd* scripts copy the required files to your SD card. You'll have to run these scripts as root, as they require low-level access to the SD card.

```
# Make sure you run the install script for your device (e.g. "install_to_sd_my-miami.sh")
cd ~/CCC-Platform/build
sudo ../meta-ccc/scripts/install_to_sd_my-miami.sh
```

# Update
This repository contains links to other repositories.
To bring your local copy of the repository up-to-date and fetch
all the sub-repositories along with it, run the following commands:

```
git pull
git submodule update
```

