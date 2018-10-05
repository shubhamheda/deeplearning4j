/*******************************************************************************
 * Copyright (c) 2015-2018 Skymind, Inc.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 ******************************************************************************/

package org.nd4j.linalg.api.ops;

import org.nd4j.autodiff.samediff.SDVariable;
import org.nd4j.autodiff.samediff.SameDiff;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.exception.ND4JIllegalArgumentException;

public abstract class BaseTransformSameOp extends BaseTransformOp implements TransformSameOp {

    public BaseTransformSameOp(SameDiff sameDiff, SDVariable i_v1, SDVariable i_v2) {
        super(sameDiff, i_v1, i_v2);
    }

    public BaseTransformSameOp(SameDiff sameDiff, SDVariable i_v1, SDVariable i_v2, boolean inPlace) {
        super(sameDiff, i_v1, i_v2, inPlace);
    }

    public BaseTransformSameOp(SameDiff sameDiff) {
        super(sameDiff);
    }

    public BaseTransformSameOp(INDArray x, INDArray y, INDArray z, long n) {
        super(x, y, z, n);
    }

    public BaseTransformSameOp(SameDiff sameDiff, SDVariable i_v1, SDVariable i_v2, Object[] extraArgs) {
        super(sameDiff, i_v1, i_v2, extraArgs);
    }

    public BaseTransformSameOp(SameDiff sameDiff, SDVariable i_v, int[] shape, boolean inPlace, Object[] extraArgs) {
        super(sameDiff, i_v, shape, inPlace, extraArgs);
    }

    public BaseTransformSameOp(SameDiff sameDiff, SDVariable i_v, boolean inPlace) {
        super(sameDiff, i_v, inPlace);
    }

    public BaseTransformSameOp(SameDiff sameDiff, SDVariable i_v, long[] shape, boolean inPlace, Object[] extraArgs) {
        super(sameDiff, i_v, shape, inPlace, extraArgs);
    }

    public BaseTransformSameOp(SameDiff sameDiff, SDVariable i_v, Object[] extraArgs) {
        super(sameDiff, i_v, extraArgs);
    }

    public BaseTransformSameOp(INDArray x, INDArray z) {
        super(x, z);
    }

    public BaseTransformSameOp() {
        super();
    }

    public BaseTransformSameOp(INDArray x, INDArray z, long n) {
        super(x, z, n);
    }


    public BaseTransformSameOp(INDArray x) {
        super(x);
    }

    @Override
    public Type getOpType() {
        return Type.TRANSFORM_SAME;
    }

    @Override
    public DataType resultType() {
        return this.x().dataType();
    }

    @Override
    public boolean validateDataTypes() {
        if (y() != null) {
            if (x().dataType() != y().dataType())
                throw new ND4JIllegalArgumentException("Op.X type must be the same as Op.Y type");
        }

        if (z() != null && z().dataType() != x().dataType())
            throw new ND4JIllegalArgumentException("Op.Z must be the same as Op.Z type");

        return true;
    }
}
