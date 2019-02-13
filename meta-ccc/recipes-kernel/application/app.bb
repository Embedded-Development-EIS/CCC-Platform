SUMMARY = "Automatically start and stop user application"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${META_ZYNQ_BASE}/COPYING;md5=751419260aa954499f7abaabaa882bbe"
PV = "1"

inherit allarch update-rc.d

SRC_URI = "file://control-manager"

S = "${WORKDIR}"
PACKAGES = "${PN}"
FILES_${PN} = "${sysconfdir}"

# Startup 
INITSCRIPT_NAME = "control-manager"

INITSCRIPT_PARAMS = "start 01 2 3 4 5 ."

do_compile() {
}

do_install() {
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${S}/control-manager ${D}${sysconfdir}/init.d/${INITSCRIPT_NAME}
}
