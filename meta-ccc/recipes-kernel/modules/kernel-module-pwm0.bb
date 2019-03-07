SUMMARY = "Kernel driver module to generate pwm signal"
require kernel-module-eis.inc
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8264535c0c4e9c6c335635c4026a8022"

SRCREV = "a1bb33b6d43e1afb78116b7236fb451f387ae0a6"

# Prefix the module with an underscore to make it load sooner.
do_install_append() {
	install -d ${D}/etc/modules-load.d
	echo "${MODULE}" >> ${D}/etc/modules-load.d/_${MODULE}.conf
}
