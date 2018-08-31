require recipes-bsp/u-boot/u-boot.inc

# Copied from OE-core recipes-bsp/u-boot/u-boot-common_2017.01.inc since this
# part was removed from u-boot.inc

HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"
SRC_URI = "git://git.denx.de/u-boot.git"

S = "${WORKDIR}/git"

DEPENDS += "dtc-native"

#  "v2017.01"

SRCREV = "a705ebc81b7f91bbd0ef7c634284208342901149"


# Patches for all boards. Use _append so it applies to everything.
SRC_URI_append = "\
	file://0001-board-topic-Detect-RAM-size-at-boot.patch \
	file://0002-topic_miami_defconfig-Remove-NFS-and-NET-support.patch \
	file://0004-configs-topic_miami.h-Correct-kernel_size-in-default.patch \
	"

PV = "v2017.01+git${SRCPV}"

SPL_BINARY = "spl/boot.bin"
SPL_SYMLINK = "BOOT.bin"

UBOOT_SUFFIX = "img"
