package green_green_avk.wayland.protocol.wayland;

/*
 * Copyright © 2008-2011 Kristian Høgsberg
 * Copyright © 2010-2011 Intel Corporation
 * Copyright © 2012-2013 Collabora, Ltd.
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation files
 * (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge,
 * publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice (including the
 * next paragraph) shall be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT.  IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 * BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 * ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import green_green_avk.wayland.protocol_core.WlInterface;

/**
 * content for a wl_surface
 *
 * A buffer provides the content for a wl_surface. Buffers are
 * created through factory interfaces such as wl_drm, wl_shm or
 * similar. It has a width and a height and can be attached to a
 * wl_surface, but the mechanism by which a client provides and
 * updates the contents is defined by the buffer factory interface.
 */
public class wl_buffer extends WlInterface<wl_buffer.Requests, wl_buffer.Events> {
    public static final int version = 1;

    public interface Requests extends WlInterface.Requests {

        /**
         * destroy a buffer
         *
         * Destroy a buffer. If and how you need to release the backing
         * storage is defined by the buffer factory interface.
         *
         * For possible side-effects to a surface, see wl_surface.attach.
         */
        @IMethod(0)
        @IDtor
        void destroy();
    }

    public interface Events extends WlInterface.Events {

        /**
         * compositor releases buffer
         *
         * Sent when this wl_buffer is no longer used by the compositor.
         * The client is now free to reuse or destroy this buffer and its
         * backing storage.
         *
         * If a client receives a release event before the frame callback
         * requested in the same wl_surface.commit that attaches this
         * wl_buffer to a surface, then the client is immediately free to
         * reuse the buffer and its backing storage, and does not need a
         * second buffer for the next surface content update. Typically
         * this is possible, when the compositor maintains a copy of the
         * wl_surface contents, e.g. as a GL texture. This is an important
         * optimization for GL(ES) compositors with wl_shm clients.
         */
        @IMethod(0)
        void release();
    }

    public static final class Enums {
        private Enums() {
        }
    }
}